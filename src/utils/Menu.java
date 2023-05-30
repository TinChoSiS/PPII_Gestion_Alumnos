package utils;

public class Menu {
    private String options[] = { "Opcion 1", "Opcion 2", "Opcion 3" };
    private String optExit = "Salir";

    private String titleTxt = "Bienvenido a Programación II";
    private int titleMargin = 6;
    private int barLength = 50 + titleMargin;

    public Menu() {
    }

    public Menu(String[] opt) {
        this.options = opt;
    }

    public Menu(String[] opt, String exitText) {
        this.options = opt;
        this.optExit = exitText;
    }

    public int showMenu(String[] opt) {
        this.options = opt;
        return showMenu();
    }

    public int showMenu() {
        int option = -1;

        try {

            for (int i = 0; i < this.options.length; i++) {
                Utils.println("[" + (i + 1) + "] - " + this.options[i]);
            }
            // Imprimir opcion de salida.
            Utils.println("[0] - " + this.optExit + "\n");

            Utils.print("Ingrese una Opción: ");

            option = Utils.nextInt();

        } catch (Exception e) {
            option = -1;
        }
        return option;
    }

    public void printTitle() {
        printTitle("", "|", false, "#");
    }

    public void printTitle(String title) {
        printTitle(title, "|", false, "#");
    }

    public void printTitle(String title, String symbolText) {
        printTitle(title, symbolText, false, "#");
    }

    public void printTitle(String title, boolean lines, String symbolLines) {
        printTitle(title, "|", lines, symbolLines);
    }

    public void printTitle(String title, String symbolText, boolean lines, String symbolLines) {
        String tempTitle = title.length() == 0 ? this.titleTxt : title;

        int titleTxtLength = tempTitle.length() + 4;
        int barTextLength = this.barLength - titleTxtLength;

        if (titleTxtLength + this.titleMargin >= this.barLength)
            barLength = titleTxtLength + this.titleMargin;

        // System.out.print("\n");

        if (lines) {
            Utils.printLine(this.barLength, symbolLines);
        }

        for (int i = 0; i < barTextLength / 2; i++) {
            Utils.print(symbolText);
        }

        Utils.print("  " + tempTitle + "  ");

        for (int i = 0; i < barTextLength / 2; i++) {
            Utils.print(symbolText);
        }

        Utils.print("\n");

        if (lines) {
            Utils.printLine(this.barLength, symbolLines);
        }
    }

}
