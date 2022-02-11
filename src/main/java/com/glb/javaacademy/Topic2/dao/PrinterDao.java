package com.glb.javaacademy.Topic2.dao;
import com.glb.javaacademy.Topic2.model.Printer;
import java.util.List;

public interface PrinterDao {
    public Printer addPrinter(Printer printer);
    public String printDocument(Printer printer, String document, String printType);

    List<Printer> getPrinters(String typePrinter);
    Printer getPrinter(int id);
}
