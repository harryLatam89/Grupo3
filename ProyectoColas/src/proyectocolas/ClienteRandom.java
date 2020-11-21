package proyectocolas;

import java.util.Random;
import java.util.Calendar;
import java.util.Random;

public class ClienteRandom {

    private String nombres[] = {"José", "Manuel", "María", "Carmen", "Jesús ", "Antonio", "Cristina", "Jordi", "Mikel", "Javier", "Francisco ", "Mohamed", "Lucas", "Hugo", "Isabel", "Pablo", "Ana", "Lucía", "Antonia",
        "Dolores", "Laura", "Mario", "David", "Marcos", "Daniel"};
    private String apellidos[] = {"Acosta", "Castellanos", "Domínguez", "Correa", "Enríquez", "Estrada", "Alayón", "Falcón",
        "Ferreira", "Figueras", "Galán", "Gallegos", "Gillén", "Gómez", "Ibarra", "Lafuente", "Llano", "Lobo", "López", "Machado", "Martínez", "Navarro", "Ochoa", "Peraza", "Quijada"};

    private String condiciones[] = {"Cliente", "Tercera edad", "Tercera edad", "Embarazada", "Discapacitado"};
    private String tipoTr[] = {"Apertura de Cuenta", "Deposito", "Retiro", "Pago Recibos", "WesternUnion", "Empresa"};

    private String nombre, apellido, condicion, tipoTrans;
    private int edad;
    private Random tomar = new Random();

    public ClienteRandom() {
        nombre = nombres[tomar.nextInt(25)];
        apellido = apellidos[tomar.nextInt(25)];
        condicion = condiciones[tomar.nextInt(5)];
        tipoTrans = tipoTr[tomar.nextInt(6)];
        edad = tomar.nextInt(90) + 18;
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

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public String getTipoTrans() {
        return tipoTrans;
    }

    public void setTipoTrans(String tipoTrans) {
        this.tipoTrans = tipoTrans;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

}
