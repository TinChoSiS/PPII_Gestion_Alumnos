package handlers;

import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import utils.Utils;

public class ErrorHandler {
    private String LogErrorPath = System.getProperty("user.dir") + "\\logs\\errors.log";

    private Exception err;
    private final Logger logger = Logger.getLogger(ErrorHandler.class.getName());
    private FileHandler fh = null;

    public ErrorHandler(Exception e){
        this.err = e;
        printErrorMsj(e);
    }


    private boolean printErrorMsj(Exception e2) {
        
        Utils.print("\n\n");
        Utils.println("Se produjo un error, vea el archivo de logs para mas información. ");

        try {
            this.fh = new FileHandler(LogErrorPath);
            this.logger.addHandler(fh);

            // DEBUG set: true
            // logger.setUseParentHandlers(false);

            SimpleFormatter formatter = new SimpleFormatter();
            this.fh.setFormatter(formatter);

            this.logger.severe(this.err.getMessage());

        } catch (Exception e) {
            Utils.println("No se pudo crear el archivo de logs.");
        } finally {
            this.fh.close();
        }
        e2.printStackTrace();
        System.exit(1);
        return false;

    }

}
