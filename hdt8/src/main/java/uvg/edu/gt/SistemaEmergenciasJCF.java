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
                String[] datos = linea.split(",");
                String nombre = datos[0].trim();
                String sintoma = datos[1].trim();
                char codigoEmergencia = datos[2].trim().charAt(0);
                Paciente paciente = new Paciente(nombre, sintoma, codigoEmergencia);
                colaEmergencias.add(paciente);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Atender pacientes en orden de prioridad
        while (!colaEmergencias.isEmpty()) {
            Paciente siguientePaciente = colaEmergencias.poll();
            System.out.println("Atendiendo a: " + siguientePaciente);
        }
    }
}