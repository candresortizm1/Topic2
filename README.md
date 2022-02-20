# Topic2

La manera en la que pienso pueda solucionarse el problema futuro de las impresoras sólamente a color es: quitar la anotación @Primary de la clase BlackWhitePrinter, y ponerla en la clase de ColorPrinter, de esta manera el PrinterDao del PrinterService sería de tipo ColorPrinter.