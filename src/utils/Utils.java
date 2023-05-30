package utils;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Utils {
    /**
     * Limpia panatalla
     */
    public static void flushScreen() {
        // extraido de Stackoverflow
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static int nextInt() {
        Scanner inScanner = new Scanner(System.in, "UTF-8");
        int usrInput = 0;
        try {
            usrInput = Integer.parseInt(inScanner.next());
        } catch (Exception e) {
            usrInput = -1;
        }
        if (inScanner.hasNext()) {
            inScanner.nextLine();
        }
        inScanner.close();
        return usrInput;
    }

    public static String nextLine() {
        Scanner inScanner = new Scanner(System.in, "UTF-8");
        String usrInput = "";
        try {
            usrInput = inScanner.nextLine();
        } catch (Exception e) {
            usrInput = "";
        }
        inScanner.close();
        return usrInput;
    }

    public static String next(){
        Scanner inScanner = new Scanner(System.in, "UTF-8");
        String usrInput = "";
        try {
            usrInput = inScanner.next();
        } catch (Exception e) {
            usrInput = "";
        }
        inScanner.close();
        return usrInput;
    }

    public static void continueConfirm() {
        Scanner inScanner = new Scanner(System.in, "UTF-8");
        println();
        print("Presione ENTER para continuar...");
        inScanner.nextLine();
        inScanner.close();

    }

    public static void print(String str) {
        PrintStream ps = null;
        try {
            ps = new PrintStream(System.out, true, "UTF-8");
            ps.print(str);
        } catch (UnsupportedEncodingException error) {
            System.exit(-1);
        }
    }

    public static void println() {
        System.out.print("\n");
    }

    public static void println(String str) {
        print(str);
        System.out.print("\n");
    }

    /**
     * Imprimir una linea
     */
    public static void printLine() {
        printLine(60, "#");
    }

    public static void printLine(String symbol) {
        printLine(60, symbol);
    }

    public static void printLine(int length, String symbol) {

        for (int i = 0; i < length; i++) {
            Utils.print(symbol);
        }
        System.out.print("\n");
    }
}
