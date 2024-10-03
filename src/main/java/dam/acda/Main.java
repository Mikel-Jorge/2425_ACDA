package dam.acda;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

//TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
// to see how IntelliJ IDEA suggests fixing it.

//TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
// for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.


import dam.acda.ut1.*;

public class Main {
    public static void main(String[] args) {

        testUT1(args);
    }

    private static void testUT1(String[] args) {

        // Test Actividad 1
        A1_Ficheros_Directorios a1 = new A1_Ficheros_Directorios();
        a1.start(args);

        // Test Actividad 2
        A2_Ficheros_Caracteres a2 = new A2_Ficheros_Caracteres();
        a2.start();

        // Test Actividad 3
        A3_Ficheros_Completo a3 = new A3_Ficheros_Completo();
        a3.start();

        // Test Actividad 4
        A4_FicherosCSV a4 = new A4_FicherosCSV();
        a4.start();

        // Test Actividad 5
        A5_LecturaXML a5 = new A5_LecturaXML();
        a5.start();

        // Test Actividad 7
        A7_FicherosJSON a7 = new A7_FicherosJSON();
        a7.start();

        // Test Actividad 8
        A8_FicherosBinarios a8 = new A8_FicherosBinarios();
        a8.start();
    }
}