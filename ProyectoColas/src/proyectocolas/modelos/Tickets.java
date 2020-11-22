/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocolas.modelos;

import java.util.Date;

/**
 *
 * @author T420S
 */
public class Tickets {

    private String numero;
    private TiposColas tipoCola;
    private Date horaEntrada;
    private Cliente cliente;
    private Transacciones tipoTransac;
    private Tickets siguiente;

    public Tickets(String numero, TiposColas tipoCola, Cliente cliente, Transacciones tipoTransac) {
        horaEntrada = new Date();
        this.tipoCola = tipoCola;
        this.numero = numero;
        this.cliente = cliente;
        this.tipoTransac = tipoTransac;
    }

    public String getNumero() {
        return numero;
    }

    public TiposColas getTipoCola() {
        return tipoCola;
    }

    public Date getHoraEntrada() {
        return horaEntrada;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Transacciones getTipoTransac() {
        return tipoTransac;
    }

    public Tickets getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Tickets siguiente) {
        this.siguiente = siguiente;
    }
    
    

}
