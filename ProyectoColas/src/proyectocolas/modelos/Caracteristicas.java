package proyectocolas.modelos;

public class Caracteristicas {

    private int numero;
    private String nombre;
    private String descripcion;
    public static int contador;

    public Caracteristicas() {
        this.numero = ++Caracteristicas.contador;
    }

    public Caracteristicas(String nombre, String descripcion) {
        this();
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
