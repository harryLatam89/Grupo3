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
public class TiposColas {

    private char tipo;
    private List<Caracteristicas> caracteristicas;

    public TiposColas(char tipo) {
        caracteristicas = new ArrayList<>();
        this.tipo = tipo;
    }

    public TiposColas(char tipo, List<Caracteristicas> caracteristicas) {
        this.tipo = tipo;
        this.caracteristicas = caracteristicas;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public List<Caracteristicas> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(List<Caracteristicas> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

}
