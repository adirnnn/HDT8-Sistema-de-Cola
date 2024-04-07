package uvg.edu.gt;

public class Paciente implements Comparable<Paciente> {
    String nombre;            // Nombre del paciente
    String sintoma;           // Síntoma del paciente
    char codigoEmergencia;    // Código de emergencia del paciente

    public Paciente(String nombre, String sintoma, char codigoEmergencia) {
        this.nombre = nombre;
        this.sintoma = sintoma;
        this.codigoEmergencia = codigoEmergencia;
    }

    // Método compareTo para comparar la prioridad de dos pacientes basándose en su código de emergencia.
    @Override
    public int compareTo(Paciente otro) {
        return this.codigoEmergencia - otro.codigoEmergencia;
    }

    // Método toString para obtener una representación en forma de cadena de texto del paciente.
    @Override
    public String toString() {
        return nombre + ", " + sintoma + ", " + codigoEmergencia;
    }
}