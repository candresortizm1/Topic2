package com.glb.javaacademy.Topic2.controller;

import com.glb.javaacademy.Topic2.model.Printer;
import com.glb.javaacademy.Topic2.service.PrinterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/printers")
public class PrinterController {

    private PrinterService printerService;

    @Autowired
    public PrinterController(PrinterService printerService) {
        this.printerService = printerService;
    }

    /* Purpose: Method to add a new printer:
    * In: A JSON with params name(String), blackWhite(boolean) and color(boolean)
    * Out: the Printer added
    * */
    @PostMapping
    public Printer addPrinter(@RequestBody Printer printer){
        return printerService.addPrinter(printer);
    }

    /* Purpose: Get available printers:
     * In: a request param with the name 'typePrinter' (optional) with the
     *     values 'black' or 'color' if want to be filtered
     * Out: the list of printers
     * */
    @GetMapping
    public List<Printer> getPrinters(@RequestParam(name="typePrinter",required = false) String typePrinter){
        return printerService.getPrinters(typePrinter);
    }

    /* Purpose: Print a document:
     * In: a request param with the id of the printer and the body request with the fields:
     *      - 'document' (string) it is the document to be printed
     *      - 'typePrint' (string) with values 'black' or 'color'
     * Out: the Message of success or fail with their respective http response code
     * */
    @PostMapping
    @RequestMapping("/{printerId}/printDocument")
    public ResponseEntity<String> printDocument(@PathVariable int printerId, @RequestBody Map<String,String> allParams){
        try{
            return printerService.printDocument(printerId,allParams);
        }catch(Exception e){
            return new ResponseEntity<String>("An error was happened", HttpStatus.BAD_REQUEST);
        }

    }
}
