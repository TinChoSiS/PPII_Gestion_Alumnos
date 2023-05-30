package app;

import DB.DBController;
import models.Usuario;
import utils.Menu;
import utils.Utils;

abstract class BaseApp {
    
    protected Usuario loggedUser = null;
    protected String titleString = "";
    protected String menuOptions[] = {};
    protected DBController dbCtrl = new DBController();

    
    public BaseApp(Usuario loggedUser, String titleString, String[] menuOptions) {
        this.loggedUser = loggedUser;
        this.menuOptions = menuOptions;
        this.titleString = titleString;

        run();
    }

    protected void run() {
        int usrMenuSelect;

        Menu mainMenu = new Menu(menuOptions);

        do {
            // Utils.flushScreen();
            usrMenuSelect = -1;
            mainMenu.printTitle("Sistema de Gestión de Alumnos", true, "#");

            mainMenu.printTitle(titleString, "=");
            Utils.println("Usuario: " + loggedUser.getName());

            Utils.println();
            usrMenuSelect = mainMenu.showMenu();

            runSelectOption(usrMenuSelect);

        } while (usrMenuSelect != 0);
    }

    abstract void runSelectOption(int usrMenuSelect);

}
