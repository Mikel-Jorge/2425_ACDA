package dam.acda;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

//TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
// to see how IntelliJ IDEA suggests fixing it.

//TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
// for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.


import dam.acda.ut1.A1_Ficheros_Directorios;

public class Main {
    public static void main(String[] args) {

        testUT1(args);
    }

    private static void testUT1(String[] args) {
        A1_Ficheros_Directorios a = new A1_Ficheros_Directorios();
        a.start(args);
    }
}