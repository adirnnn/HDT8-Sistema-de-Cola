package uvg.edu.gt;

public class Paciente implements Comparable<Paciente> {
    String nombre;
    String sintoma;
    char codigoEmergencia;

    public Paciente(String nombre, String sintoma, char codigoEmergencia) {
        this.nombre = nombre;
        this.sintoma = sintoma;
        this.codigoEmergencia = codigoEmergencia;
    }

    @Override
    public int compareTo(Paciente otro) {
        return this.codigoEmergencia - otro.codigoEmergencia;
    }

    @Override
    public String toString() {
        return nombre + ", " + sintoma + ", " + codigoEmergencia;
    }
}