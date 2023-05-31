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
        // Scanner inScanner;
        int usrInput = 0;
        try {
            usrInput = Integer.parseInt(System.console().readLine());
        } catch (Exception e) {
            usrInput = -1;
        }
        return usrInput;
    }

    public static String nextLine() {
        String usrInput = "";
        try {
            usrInput = System.console().readLine();
        } catch (Exception e) {
            usrInput = "";
        }
        return usrInput;
    }

    public static String next(){
        Scanner inScanner;
        String usrInput = "";
        try {
            inScanner = new Scanner(System.in, "UTF-8");
            usrInput = inScanner.next();
        } catch (Exception e) {
            usrInput = "";
        }
        return usrInput;
    }

    public static void continueConfirm() {
        println();
        print("Presione ENTER para continuar...");
        nextLine();

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
