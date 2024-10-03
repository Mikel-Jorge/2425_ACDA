package dam.acda.ut1;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class A7_FicherosJSON {
    public void start() {
        System.out.println("------------------------------");
        System.out.println("--  UT1 - A7 Ficheros JSON  --");
        System.out.println("------------------------------");

        // Ruta del archivo JSON original
        String inputFilePath = "src/main/resources/UT1/A7_Recursos.json";
        // Ruta del archivo JSON de salida
        String outputFilePath = "src/main/resources/UT1/resultado.json";

        try {
            String content = leerJSON(inputFilePath);

            // Parseo de String a JSON
            JSONObject jsonObject = new JSONObject(content);

            // Mostrar el contenido del archivo JSON
            System.out.println("Contenido del archivo JSON:");
            // Formato de impresión con 4 espacios de indentación
            System.out.println(jsonObject.toString(4));

            // Hacer un sumatorio de los salarios de los empleados que están activos
            JSONArray empleados = jsonObject.getJSONArray("empleados");
            double sumatorioSalarios = 0;
            for (int i = 0; i < empleados.length(); i++) {
                JSONObject empleado = empleados.getJSONObject(i);
                if (empleado.getBoolean("activo")) {
                    if (!empleado.isNull("salario")) {
                        sumatorioSalarios += empleado.getDouble("salario");
                    }
                }
            }
            System.out.println("\nSumatorio de salarios de empleados activos: " + sumatorioSalarios);

            // Contar el número total de proyectos
            JSONArray proyectos = jsonObject.getJSONArray("proyectos");
            int totalProyectos = proyectos.length();
            System.out.println("Número total de proyectos: " + totalProyectos);

            escribirJSON(outputFilePath, empleados, sumatorioSalarios, totalProyectos);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void escribirJSON(String outputFilePath, JSONArray empleados, double sumatorioSalarios, int totalProyectos) throws IOException {
        // Crear el nuevo objeto JSON para el archivo de salida
        JSONObject resultado = new JSONObject();
        resultado.put("empleados", empleados); // Copiar los empleados
        resultado.put("sumatorioSalarios", sumatorioSalarios);
        resultado.put("totalProyectos", totalProyectos);

        // Escribir el nuevo archivo JSON
        try (FileWriter fileWriter = new FileWriter(outputFilePath)) {
            fileWriter.write(resultado.toString(4)); // Escribir con indentación
            System.out.println("\nNuevo archivo JSON guardado en: " + outputFilePath);
        }
    }

    private String leerJSON(String inputFilePath) throws IOException {
        StringBuilder contenido = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))) {
            // Leo el fichero y lo concateno
            while (br.ready())
                contenido.append(br.readLine());
        }

        return contenido.toString();
    }
}
