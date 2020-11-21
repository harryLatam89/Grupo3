/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocolas.modelos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author T420S
 */
public class ConfiguracionCaja {

    private int numeroCaja;
    private List<TiposColas> tiposColases;

    public ConfiguracionCaja() {
        tiposColases = new ArrayList<>();
    }

    public ConfiguracionCaja(int numeroCaja) {
        this.numeroCaja = numeroCaja;
        tiposColases = new ArrayList<>();
    }

    public int getNumeroCaja() {
        return numeroCaja;
    }

    public void setNumeroCaja(int numeroCaja) {
        this.numeroCaja = numeroCaja;
    }

    public List<TiposColas> getTiposColases() {
        return tiposColases;
    }

    public void setTiposColases(List<TiposColas> tiposColases) {
        this.tiposColases = tiposColases;
    }

}
