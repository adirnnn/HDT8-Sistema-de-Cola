package uvg.edu.gt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class App {
    public static void main(String[] args) {
        Vector<Paciente> pacientes = new Vector<>();
        VectorHeap<Paciente> colaEmergencias = new VectorHeap<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/java/uvg/edu/gt/resources/pacientes.txt"));
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                String nombre = datos[0].trim();
                String sintoma = datos[1].trim();
                char codigoEmergencia = datos[2].trim().charAt(0);
                Paciente paciente = new Paciente(nombre, sintoma, codigoEmergencia);
                pacientes.add(paciente);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Paciente paciente : pacientes) {
            colaEmergencias.add(paciente);
        }

        // Atender pacientes en orden de prioridad
        while (!colaEmergencias.isEmpty()) {
            Paciente siguientePaciente = colaEmergencias.remove();
            System.out.println("Atendiendo a: " + siguientePaciente);
        }
    }
}