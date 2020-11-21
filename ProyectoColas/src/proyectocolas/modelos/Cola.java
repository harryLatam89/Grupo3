package proyectocolas.modelos;

import java.util.ArrayList;
import java.util.List;
import proyectocolas.modelos.Cliente;
import javax.swing.JOptionPane;
import proyectocolas.ClienteRandom;
import proyectocolas.Reportes;
import proyectocolas.reporte.Datos;

public class Cola {

    /**
     * *** BANCO ***
     */
    private static int crltv = 0;
    public static Cliente inicioCola, finalCola;
    public static int apertura, deposito, retiro, pagoRecibos, westerUnion, empresa;
    public static int embaraza, discapacitado, terceraEdad, cliente;

    String Cola = "";

    public Cola() {
        inicioCola = null;
        finalCola = null;

    }

    public boolean ColaVacia() {
        if (inicioCola == null) {
            return true;
        } else {
            return false;

        }
    }
//  JOptionPane.showMessageDialog(null, "dato inicial apertura"+ Apertura);

    public void ingresar(String nombre, String apellido, int edad, String condicion, String tipoTrans) {

        contadores(condicion, tipoTrans);
        String tkt = numtkt(condicion);

        Cliente nuevo_nodo = new Cliente(nombre, apellido, edad, condicion, tipoTrans, tkt);

        if (inicioCola == null) {
            inicioCola = finalCola = nuevo_nodo;
        } else if (inicioCola.prioridad > nuevo_nodo.prioridad) {
            nuevo_nodo.setSiguiente(inicioCola);
            inicioCola = nuevo_nodo;
        } else {
            Cliente ant = null;
            Cliente sig = inicioCola;
            while (sig != null && nuevo_nodo.prioridad >= sig.prioridad) {
                ant = sig;
                sig = sig.getSiguiente();
            }
            nuevo_nodo.setSiguiente(sig);
            ant.setSiguiente(nuevo_nodo);
            if (sig == null) {
                finalCola = nuevo_nodo;
            }

        }

    }

    public static String[] vecRegistro(Cliente nodo) {

        String nom = nodo.getNombre();
        String apell = nodo.getApellido();
        String cond = nodo.getCondicion();
        String transac = nodo.getTipoTransaccion();
        String tkt = nodo.getNumerodeTicket();
        String vec[] = {nom, apell, cond, transac, tkt};
        return vec;
    }

    public Cliente getInicioCola() {
        return inicioCola;
    }

    public static Cliente getFinalCola() {
        return finalCola;
    }

    public void despachar() {

        if (inicioCola != null) {
            inicioCola = inicioCola.siguiente;
            if (inicioCola == null) {
                finalCola = null;
            }

        } else {
            JOptionPane.showMessageDialog(null, "lista vacia");
        }

    }

    public void contadores(String condicion, String tipoTrans) {

        crltv++;
        switch (condicion) {
            case "Discapacitado":
                discapacitado++;
                break;

            case "Tercera edad":
                terceraEdad++;
                break;

            case "Embarazada":
                embaraza++;
                break;
            case "Cliente":
                cliente++;
                break;
        }

        switch (tipoTrans) {
            case "Deposito":
                deposito++;
                break;

            case "Retiro":
                retiro++;
                break;

            case "Apertura de Cuenta":
                apertura++;
                break;
            case "Pago Recibos":
                pagoRecibos++;
                break;
            case "WesternUnion":
                pagoRecibos++;
                break;
            case "Empresa":
                empresa++;
                break;

        }

    }

    public static String numtkt(String prio) {

        String valor = "";

        switch (prio) {
            case "Discapacitado":
                valor = "D" + discapacitado;
                break;

            case "Tercera edad":
                valor = "T" + terceraEdad;
                break;

            case "Embarazada":
                valor = "E" + embaraza;
                break;
            case "Cliente":
                valor = "C" + cliente;

        }

        return valor;
    }

    public void vaciar() {
        inicioCola = finalCola = null;
    }

    public void estadisticos() {
//        JOptionPane.showMessageDialog(null,
//                " Estadisticos "
//                + "   **por tipo transaccion***\n"
//                + "  Apertura de Cuenta" + apertura + " \n"
//                + "  Deposito" + deposito + " \n"
//                + "  Retiro " + retiro + "\n "
//                + "  Pago Recibos " + pagoRecibos + "\n");
        List<Datos> lista = new ArrayList<>();
        lista.add(new Datos("Apertura de Cuenta", apertura));
        lista.add(new Datos("Deposito", deposito));
        lista.add(new Datos("Retiro", retiro));
        lista.add(new Datos("Pago Recibos", pagoRecibos));
        Reportes reportes = new Reportes();
        reportes.generarReporteDelDia(lista);
    }

    public void ingresosAleatorio() {

        ClienteRandom alt = new ClienteRandom();

        contadores(alt.getCondicion(), alt.getTipoTrans());
        String tkt = numtkt(alt.getCondicion());

        Cliente nuevo_nodo = new Cliente(alt.getNombre(), alt.getApellido(), alt.getEdad(), alt.getCondicion(), alt.getTipoTrans(), tkt);

        if (inicioCola == null) {
            inicioCola = finalCola = nuevo_nodo;
        } else if (inicioCola.prioridad > nuevo_nodo.prioridad) {
            nuevo_nodo.setSiguiente(inicioCola);
            inicioCola = nuevo_nodo;
        } else {
            Cliente ant = null;
            Cliente sig = inicioCola;
            while (sig != null && nuevo_nodo.prioridad >= sig.prioridad) {
                ant = sig;
                sig = sig.getSiguiente();
            }
            nuevo_nodo.setSiguiente(sig);
            ant.setSiguiente(nuevo_nodo);
            if (sig == null) {
                finalCola = nuevo_nodo;
            }

        }

    }

}
