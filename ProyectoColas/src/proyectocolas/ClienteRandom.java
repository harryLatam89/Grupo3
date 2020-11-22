package proyectocolas;

import java.util.List;
import java.util.Random;
import proyectocolas.datos.DataGlobal;
import proyectocolas.modelos.Caracteristicas;
import proyectocolas.modelos.TiposColas;
import proyectocolas.modelos.Transacciones;

public class ClienteRandom {

    private String nombres[] = {"José", "Manuel", "María", "Carmen", "Jesús ", "Antonio", "Cristina", "Jordi", "Mikel", "Javier", "Francisco ", "Mohamed", "Lucas", "Hugo", "Isabel", "Pablo", "Ana", "Lucía", "Antonia",
        "Dolores", "Laura", "Mario", "David", "Marcos", "Daniel"};
    private String apellidos[] = {"Acosta", "Castellanos", "Domínguez", "Correa", "Enríquez", "Estrada", "Alayón", "Falcón",
        "Ferreira", "Figueras", "Galán", "Gallegos", "Gillén", "Gómez", "Ibarra", "Lafuente", "Llano", "Lobo", "López", "Machado", "Martínez", "Navarro", "Ochoa", "Peraza", "Quijada"};

    private Caracteristicas condicion;
    private Transacciones tipoTrans;
    private TiposColas tiposColas;
    private String nombre, apellido;
    private int edad;
    private Random tomar = new Random();

    public ClienteRandom() {
        nombre = nombres[tomar.nextInt(25)];
        apellido = apellidos[tomar.nextInt(25)];
        List<Caracteristicas> condiciones = DataGlobal.caracteristicas;
        if (condiciones == null) {
            condiciones = DataGlobal.caracteristicasIniciales();
            DataGlobal.caracteristicas = DataGlobal.caracteristicasIniciales();
        }
        condicion = condiciones.get(tomar.nextInt(condiciones.size()));
        List<Transacciones> tipoTr = DataGlobal.transacciones;
        if (tipoTr == null) {
            tipoTr = DataGlobal.transaccionesIniciales();
            DataGlobal.transacciones = DataGlobal.transaccionesIniciales();
        }
        tipoTrans = tipoTr.get(tomar.nextInt(tipoTr.size()));
        List<TiposColas> tipoCl = DataGlobal.tiposColas;
        if (tipoCl == null) {
            tipoCl = DataGlobal.tiposColasIniciales();
            DataGlobal.transacciones = DataGlobal.transaccionesIniciales();
        }
        tiposColas = tipoCl.get(tomar.nextInt(tipoCl.size()));
        edad = tomar.nextInt(90) + 18;
    }

    public String generarDui() {
        StringBuilder stb = new StringBuilder();
        stb.append(tomar.nextInt(3));
        stb.append(tomar.nextInt(7));
        stb.append(tomar.nextInt(10));
        stb.append(tomar.nextInt(10));
        stb.append(tomar.nextInt(10));
        stb.append(tomar.nextInt(10));
        stb.append(tomar.nextInt(10));
        stb.append(tomar.nextInt(10));
        stb.append(tomar.nextInt(10));
        String st = stb.toString();
        return st;
    }

    public String[] getNombres() {
        return nombres;
    }

    public String[] getApellidos() {
        return apellidos;
    }

    public Caracteristicas getCondicion() {
        return condicion;
    }

    public Transacciones getTipoTrans() {
        return tipoTrans;
    }

    public TiposColas getTiposColas() {
        return tiposColas;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public Random getTomar() {
        return tomar;
    }

}
