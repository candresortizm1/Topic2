package com.glb.javaacademy.Topic2.dao;
import com.glb.javaacademy.Topic2.model.Printer;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PrinterConcrete implements PrinterDao{

    private static List<Printer> DB = new ArrayList<>();

    @Override
    public Printer addPrinter(Printer printer) {
        printer = new Printer(DB.size()+1,
                printer.getName(),
                printer.getColor(),
                printer.getBlackWhite());
        DB.add(printer);
        return printer;
    }

    @Override
    public String printDocument(Printer printer, String document, String printType) {
        return "The document: "+document+" was printed on "+printer.getId()+" in "+printType;
    }

    @Override
    public List<Printer> getPrinters(String typePrinter) {
        if(!typePrinter.equals("all")){
            return filterPrinters(typePrinter);
        }
        return DB;
    }

    @Override
    public Printer getPrinter(int id) {
        for(Printer printer: DB){
            if(printer.getId() == id){
                return printer;
            }
        }
        return null;
    }

    private List<Printer> filterPrinters(String typePrinter){
        List<Printer> filteredPrinters = new ArrayList<Printer>();
        for(Printer printer: DB){
            if(typePrinter.equals("black") && printer.getColor()==false &&
                    printer.getBlackWhite()==true){
                filteredPrinters.add(printer);
            }else if(typePrinter.equals("color") && printer.getColor()==true &&
                    printer.getBlackWhite()==false){
                filteredPrinters.add(printer);
            }
        }
        return filteredPrinters;
    }

}
