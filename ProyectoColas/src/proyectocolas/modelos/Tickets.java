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

    private TiposColas tipoCola;
    private int numero;
    private Date horaEntrada = new Date();
    private Cliente cliente;

    public Tickets() {
    }

    public Tickets(TiposColas tipoCola, int numero, Cliente cliente) {
        this.tipoCola = tipoCola;
        this.numero = numero;
        this.cliente = cliente;
    }

    public TiposColas getTipoCola() {
        return tipoCola;
    }

    public void setTipoCola(TiposColas tipoCola) {
        this.tipoCola = tipoCola;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(Date horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
