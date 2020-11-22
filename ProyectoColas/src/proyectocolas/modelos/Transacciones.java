package proyectocolas.modelos;

public class Transacciones {

    private int id;
    private String nombre;
    public static int contador;

    public Transacciones() {
        this.id = ++Transacciones.contador;
    }

    public Transacciones(String nombre) {
        this();
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
