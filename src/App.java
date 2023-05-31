import app.ProfesorApp;
import auth.Auth;
import handlers.ErrorHandler;
import models.Usuario;
import utils.Menu;
import utils.Utils;

public class App {
    public static void app() {
        try {
            Usuario loggedUser = null;

            Menu mainMenu = new Menu();

            Utils.flushScreen();
            Utils.println();

            mainMenu.printTitle("Inicio de Sesión", "=");

            loggedUser = Auth.login();

            Utils.flushScreen();
            if (loggedUser.isStaff()) {
                new ProfesorApp(loggedUser);
            } else {
                Utils.println("TODO: Clase EstudianteApp");
            }
        } catch (Exception e) {
            new ErrorHandler(e);
        }
    }
}
