package proyectocolas.modelos;

public class Cliente {

    private int correlativo;
    private String nombre;
    private String apellido;
    private int edad;
    private String dui;
    private int prioridad = 0;
    private Caracteristicas condicion;
    private String numerodeTicket;

    private Cliente siguiente;
    public static int contador;

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, int edad, String dui, String numerodeTicket, Caracteristicas condicion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.dui = dui;
        this.numerodeTicket = numerodeTicket;
        this.condicion = condicion;
        this.correlativo = ++Cliente.contador;
        this.siguiente = null;
    }

    public final int prioridad(Caracteristicas condicion) {
        int valor = 0;
        switch (condicion.getNumero()) {
            case 1:
                valor = 1;
                break;
            case 2:
                valor = 2;
                break;
            case 3:
                valor = 3;
                break;
            default:
                valor = 4;
                break;
        }

        return valor;
    }

    public int getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(int correlativo) {
        this.correlativo = correlativo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public Caracteristicas getCondicion() {
        return condicion;
    }

    public void setCondicion(Caracteristicas condicion) {
        this.condicion = condicion;
    }

    public String getNumerodeTicket() {
        return numerodeTicket;
    }

    public void setNumerodeTicket(String numerodeTicket) {
        this.numerodeTicket = numerodeTicket;
    }

    public Cliente getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Cliente siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public String toString() {
        return "Cliente{" + "correlativo=" + correlativo + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", dui=" + dui + ", prioridad=" + prioridad + ", condicion=" + condicion + ", numerodeTicket=" + numerodeTicket + ", siguiente=" + siguiente + '}';
    }

}
