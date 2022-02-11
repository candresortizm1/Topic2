package com.glb.javaacademy.Topic2.service;

import com.glb.javaacademy.Topic2.dao.PrinterDao;
import com.glb.javaacademy.Topic2.model.Printer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class PrinterService {

    private PrinterDao printerDao;

    @Autowired
    public PrinterService(PrinterDao printerDao){
        this.printerDao = printerDao;
    }

    public Printer addPrinter(Printer printer){
        return printerDao.addPrinter(printer);
    }

    public List<Printer> getPrinters(String typePrinter) {
        if(typePrinter!=null){
            return printerDao.getPrinters(typePrinter);
        }else{
            return printerDao.getPrinters("all");
        }
    }

    public ResponseEntity<String> printDocument(int printerId, Map<String,String> paramsMap){
        Printer printer = printerDao.getPrinter(printerId);
        String typePrint = paramsMap.get("typePrint");
        String document = paramsMap.get("document");
        if((typePrint.equals("color") && !printer.getColor()) ||
                (typePrint.equals("black") && !printer.getBlackWhite())){
            String response = "Doesn't possible print in  "+typePrint+
                    " with the printer: "+printer.getName();
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(printerDao.printDocument(printer,document,typePrint),HttpStatus.ACCEPTED);
    }

}
