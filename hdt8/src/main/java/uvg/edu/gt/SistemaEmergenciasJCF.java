package uvg.edu.gt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;

public class SistemaEmergenciasJCF {
    public static void main(String[] args) {
        PriorityQueue<Paciente> colaEmergencias = new PriorityQueue<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/java/uvg/edu/gt/resources/pacientes.txt"));
            String linea;
            while ((linea = br.readLine()) != null) {
                // Separación de los datos de cada paciente por coma
                String[] datos = linea.split(",");
                // Extracción de los datos del paciente (nombre, síntoma, código de emergencia)
                String nombre = datos[0].trim();
                String sintoma = datos[1].trim();
                char codigoEmergencia = datos[2].trim().charAt(0);
                // Creación de un nuevo objeto Paciente con los datos extraídos
                Paciente paciente = new Paciente(nombre, sintoma, codigoEmergencia);
                // Agrega el paciente a la cola de emergencias
                colaEmergencias.add(paciente);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Para atender pacientes en orden de prioridad
        while (!colaEmergencias.isEmpty()) {
            // Retira el siguiente paciente de mayor prioridad de la cola de emergencias
            Paciente siguientePaciente = colaEmergencias.poll();
            // Muestra en consola que se está atendiendo al paciente
            System.out.println("Atendiendo a: " + siguientePaciente);
        }
    }
}