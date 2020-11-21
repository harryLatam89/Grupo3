/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocolas.reporte;

import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author T420S
 */
public class DatosJasperAdapter implements JRDataSource {

    private List<Datos> lista = new ArrayList<>();
    private int indice = -1;

    public List<Datos> getLista() {
        return lista;
    }

    public void setLista(List<Datos> lista) {
        this.lista = lista;
    }

    @Override
    public boolean next() throws JRException {
        indice++;
        return indice < lista.size();
    }

    @Override
    public Object getFieldValue(JRField jrField) throws JRException {
        Object fieldValue = null;
        if ("nombre".equals(jrField.getName())) {
            fieldValue = this.lista.get(indice).getNombre();
        }
        if ("cantidad".equals(jrField.getName())) {
            fieldValue = this.lista.get(indice).getCantidad();
        }
        return fieldValue;
    }

}
