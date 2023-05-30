package app;

import java.util.List;

import models.Usuario;
import utils.Menu;
import utils.Utils;

public class ProfesorApp extends BaseApp {

    private static String titleString = "Profesor";
    private static String[] menuOptions = {
            "Crear Alumno",
            "Ver Alumnos",
    };

    public ProfesorApp(Usuario loggedUser) {
        super(loggedUser, titleString, menuOptions);
    }

    @Override
    protected void runSelectOption(int usrMenuSelect) {
        switch (usrMenuSelect) {
            case 1:
                System.out.println("Crear Alumno");
                break;
            case 2:
                verAlumnos(null);
                break;
            default:
                break;
        }
    }

    private void verAlumnos(String filter) {
        Utils.flushScreen();
        List<Usuario> alumnos = this.dbCtrl.selectAlumnos(filter);
        new Menu().printTitle("Alumnos", "=");

        Utils.println("ID\t|Nombre\t\t|Grupo\t|Calificacion");
        for (Usuario alumno : alumnos) {

            Utils.println(alumno.getId()
                    + "\t|" + alumno.getName()
                    + "\t|" + alumno.getGrupo()
                    + "\t|" + alumno.getCalificacion());
        }
        Utils.continueConfirm();
    }

}
