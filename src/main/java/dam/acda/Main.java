package dam.acda;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

//TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
// to see how IntelliJ IDEA suggests fixing it.

//TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
// for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.


import dam.acda.ut1.A1_Ficheros_Directorios;
import dam.acda.ut1.A2_Ficheros_Caracteres;

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
    }
}