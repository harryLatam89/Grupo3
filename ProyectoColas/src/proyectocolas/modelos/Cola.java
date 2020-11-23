package proyectocolas.modelos;

import java.util.List;
import javax.swing.JOptionPane;
import proyectocolas.ClienteRandom;
import proyectocolas.datos.DataGlobal;

public class Cola {

    /**
     * *** BANCO ***
     */
    private static int crltv = 0;
    private Tickets inicioCola, finalCola;
    public static int apertura, deposito, retiro, pagoRecibos, westerUnion, empresa;
    public static int embaraza, discapacitado, terceraEdad, cliente;

    String Cola = "";

    public Cola() {
        this.inicioCola = null;
        this.finalCola = null;
    }

    public boolean ColaVacia() {
        if (this.inicioCola == null) {
            return true;
        } else {
            return false;

        }
    }
//  JOptionPane.showMessageDialog(null, "dato inicial apertura"+ Apertura);

    public void ingresar(Cliente cliente, Caracteristicas condicion, Transacciones tipoTrans) {

        contadores(condicion, tipoTrans);
        Cliente nuevo_nodo = cliente;
        Tickets ticket = new Tickets(numtkt(condicion), tpcola(condicion), cliente, tipoTrans);

        if (this.inicioCola == null) {
            this.inicioCola = this.finalCola = ticket;
        } else if (this.inicioCola.getCliente().getPrioridad() < ticket.getCliente().getPrioridad()) {
            ticket.setSiguiente(this.inicioCola);
            this.inicioCola = ticket;
        } else {
            Tickets ant = null;
            Tickets sig = this.inicioCola;
            while (sig != null && ticket.getCliente().getPrioridad() >= sig.getCliente().getPrioridad()) {
                ant = sig;
                sig = sig.getSiguiente();
            }
            ticket.setSiguiente(sig);
            ant.setSiguiente(ticket);
            if (sig == null) {
                this.finalCola = ticket;
            }

        }

    }

    public void ingresarReversa(Tickets ticket) {
        if (this.inicioCola == null) {
            this.inicioCola = this.finalCola = ticket;
        } else if (this.inicioCola.getCliente().getPrioridad() < ticket.getCliente().getPrioridad()) {
            ticket.setSiguiente(this.inicioCola);
            this.inicioCola = ticket;
        } else {
            Tickets ant = null;
            Tickets sig = this.inicioCola;
            while (sig != null && ticket.getCliente().getPrioridad() >= sig.getCliente().getPrioridad()) {
                ant = sig;
                sig = sig.getSiguiente();
            }
            ticket.setSiguiente(sig);
            ant.setSiguiente(ticket);
            if (sig == null) {
                this.finalCola = ticket;
            }

        }

    }

    public static String[] vecRegistro(Tickets nodo) {
        String nom = nodo.getCliente().getNombre();
        String apell = nodo.getCliente().getApellido();
        String cond = nodo.getCliente().getCondicion().getNombre();
        String transac = nodo.getTipoTransac().getNombre();
        String tkt = nodo.getCliente().getNumerodeTicket();
        String vec[] = {nom, apell, cond, transac, tkt};
        return vec;
    }

    public Tickets getInicioCola() {
        return this.inicioCola;
    }

    public Tickets getFinalCola() {
        return finalCola;
    }

    public void setInicioCola(Tickets inicioCola) {
        this.inicioCola = inicioCola;
    }

    public void setFinalCola(Tickets finalCola) {
        this.finalCola = finalCola;
    }

    public void despachar() {

        if (this.inicioCola != null) {
            this.inicioCola = this.inicioCola.getSiguiente();
            if (this.inicioCola == null) {
                this.finalCola = null;
            }

        } else {
            JOptionPane.showMessageDialog(null, "lista vacia");
        }

    }

    public void contadores(Caracteristicas condicion, Transacciones tipoTrans) {

        this.crltv++;
        switch (condicion.getNumero()) {
            case 4:
                this.discapacitado++;
                break;
            case 2:
                this.terceraEdad++;
                break;
            case 3:
                this.embaraza++;
                break;
            default:
                this.cliente++;
                break;
        }

    }

    public static String numtkt(Caracteristicas prio) {
        String valor = "";
        switch (prio.getNumero()) {
            case 4:
                valor = "D" + discapacitado;
                break;
            case 2:
                valor = "T" + terceraEdad;
                break;
            case 3:
                valor = "E" + embaraza;
                break;
            default:
                valor = "C" + cliente;
        }
        return valor;
    }

    public static TiposColas tpcola(Caracteristicas prio) {
        TiposColas tp = null;
        switch (prio.getNumero()) {
            case 4:
                tp = buscarTPcola('D');
                break;
            case 3:
                tp = buscarTPcola('T');
                break;
            case 2:
                tp = buscarTPcola('E');
                break;
            default:
                tp = buscarTPcola('C');
        }

        return tp;
    }

    public static TiposColas buscarTPcola(char caracter) {
        TiposColas tp = null;
        List<TiposColas> list = DataGlobal.tiposColas;
        if (list == null) {
            list = DataGlobal.tiposColasIniciales();
        }
        if (!list.isEmpty()) {
            for (TiposColas tipoCola : list) {
                if (tipoCola.getTipo() == caracter) {
                    tp = tipoCola;
                }
            }
        }
        return tp;
    }

    public void vaciar() {
        this.inicioCola = this.finalCola = null;
    }

    public void ingresosAleatorio() {

        ClienteRandom alt = new ClienteRandom();

        contadores(alt.getCondicion(), alt.getTipoTrans());

        Cliente nuevo_nodo = new Cliente(alt.getNombre(), alt.getApellido(), alt.getEdad(), alt.generarDui(), numtkt(alt.getCondicion()), alt.getCondicion());
        Tickets ticket = new Tickets(numtkt(alt.getCondicion()), tpcola(alt.getCondicion()), nuevo_nodo, alt.getTipoTrans());

        if (this.inicioCola == null) {
            this.inicioCola = this.finalCola = ticket;
        } else if (this.inicioCola.getCliente().getPrioridad() < ticket.getCliente().getPrioridad()) {
            ticket.setSiguiente(this.inicioCola);
            this.inicioCola = ticket;
        } else {
            Tickets ant = null;
            Tickets sig = this.inicioCola;
            while (sig != null && ticket.getCliente().getPrioridad() >= sig.getCliente().getPrioridad()) {
                ant = sig;
                sig = sig.getSiguiente();
            }
            ticket.setSiguiente(sig);
            ant.setSiguiente(ticket);
            if (sig == null) {
                this.finalCola = ticket;
            }
        }
        if (DataGlobal.colaEstadistica1 == null) {
            DataGlobal.colaEstadistica1 = new Cola();
        }
        DataGlobal.colaEstadistica1.ingresar(nuevo_nodo, nuevo_nodo.getCondicion(), ticket.getTipoTransac());
    }

}
