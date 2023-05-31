package auth;

import DB.DBController;
import models.Usuario;
import utils.Utils;

public class Auth {

    public static Usuario login() {
        // Scanner userFile = new Scanner(new File(usuariosPath));
        DBController dbCtrl = new DBController();

        int tryCount = 0;

        Utils.println();
        do {
            tryCount++;

            Utils.print("Nombre de Usuario: ");
            String username = Utils.nextLine();

            Utils.print("Contraseña: ");
            String password = Utils.nextLine();

            Usuario user = dbCtrl.userLogin(username, password);

            
            if (user != null) {
                Utils.print(user != null ? "Bienvenido " + user.getName() + "\n" : "");
                return user;
            }
            
            Utils.println("Usuario o contraseña incorrectos. Intentos restantes: " + (3 - tryCount));
        } while (tryCount < 3);

        System.exit(0);
        return null;

    }
}
