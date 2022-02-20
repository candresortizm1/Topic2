package com.glb.javaacademy.Topic2.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PrinterFactory {

    @Bean
    public PrinterDao blackWithePrinterDao(){
        return new BlackWhitePrinter();
    }

    @Bean
    public PrinterDao colorPrinterDao(){
        return new ColorPrinter();
    }

    public PrinterDao getPrinter(String typePrinter){
        if(typePrinter == "Black"){
            return blackWithePrinterDao();
        }else{
            return colorPrinterDao();
        }
    }
}
