package com.glb.javaacademy.Topic2.service;

import com.glb.javaacademy.Topic2.dao.PrinterDao;
import com.glb.javaacademy.Topic2.dao.PrinterFactory;
import com.glb.javaacademy.Topic2.model.Printer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class PrinterService {

    @Autowired
    private PrinterDao printerDao;

    @Autowired
    private PrinterFactory printerFactory;

    public Printer addPrinter(Printer printer){
        String typePrinter = "Black";
        if(!printer.getBlackWhite()){
            typePrinter = "Color";
        }
        return printerFactory.getPrinter(typePrinter).addPrinter(printer);
    }

    public List<Printer> getPrinters() {
        return printerDao.getPrinters();
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
