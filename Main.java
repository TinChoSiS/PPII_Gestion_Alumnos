import app.ProfesorApp;
import auth.Auth;
import handlers.ErrorHandler;
import models.Usuario;
import utils.Menu;
import utils.Utils;

/**
 * Gestion de Alumnos (Proyecto Personal Prog_II)
 */
public class Main {

    public static void main(String[] args) {
        try {
            Usuario loggedUser = null;

        Menu mainMenu = new Menu();

        Utils.flushScreen();
        System.out.print("\n");

        mainMenu.printTitle("Inicio de Sesión", "=");
        
        loggedUser = Auth.login();

        // Utils.flushScreen();
        if (loggedUser.isStaff()) {
           new ProfesorApp(loggedUser);
        } else {
            System.out.println("No tiene permisos para acceder a esta aplicación.");
        }
        } catch (Exception e) {
            new ErrorHandler(e);
        }

    }

}