/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocolas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import proyectocolas.datos.DataGlobal;
import proyectocolas.datos.MapaEstadist;
import proyectocolas.modelos.Cola;
import proyectocolas.modelos.Tickets;
import proyectocolas.reporte.Datos;
import proyectocolas.reporte.DatosJasperAdapter;

/**
 *
 * @author T420S
 */
public class Reportes {

    public void generarReporteDelDia(List<Datos> datos, String param) {
        try {
            JasperReport report = JasperCompileManager.compileReport("src/proyectocolas/reporte/reporte.jrxml");
            System.out.println("jaaperreport");
            // se invocan parametros para ser insertados en el reporte
            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("tipo", param);
            // se adaptan datos para ser insertados al reporte
            DatosJasperAdapter adapter = new DatosJasperAdapter();
            adapter.setLista(datos);
            JasperPrint jasperPrint = JasperFillManager.fillReport(report, parametros, adapter);
            System.out.println("JasperPrint");
            JasperViewer.viewReport(jasperPrint, false); // ver reporte en jasper print
        } catch (Exception e) {
            System.out.println("Error jasper report datos: " + e);
            JOptionPane.showMessageDialog(null, "Ocurrio un error al crear el reporte");
        }
    }

    public List<Tickets> obtenerUtilList(Cola colar) {
        List<Tickets> lista = new ArrayList<>();

        Tickets nodo = null;
        if (colar != null && colar.getInicioCola() != null) {
            nodo = colar.getInicioCola();
        }
        while (nodo != null) {
            lista.add(nodo);
            nodo = nodo.getSiguiente();
        }
        return lista;
    }

    public void estadisticos(Cola colax) {
        List<Tickets> ticketsr = obtenerUtilList(colax);
        if (ticketsr != null && !ticketsr.isEmpty()) {
            List<MapaEstadist> maps = new ArrayList<>();

            for (Tickets ticket : ticketsr) {
                if (maps.isEmpty()) {
                    maps.add(new MapaEstadist(ticket.getCliente().getCondicion().getNumero(), 1, ticket.getCliente().getCondicion().getNombre()));
                } else {
                    int x = 0;
                    List<MapaEstadist> maps2 = maps;
                    boolean busc = true;
                    for (MapaEstadist mp : maps) {
                        if (mp.compare(ticket.getCliente().getCondicion().getNumero())) {
                            maps2.set(x, new MapaEstadist(mp.getId(), mp.getCantidad() + 1, ticket.getCliente().getCondicion().getNombre()));
                            busc = false;
                        }
                        x++;
                    }
                    maps = maps2;
                    if (busc) {
                        maps.add(new MapaEstadist(ticket.getCliente().getCondicion().getNumero(), 1, ticket.getCliente().getCondicion().getNombre()));
                    }
                }
            }
            List<Datos> lista = new ArrayList<>();
            for (MapaEstadist map : maps) {
                lista.add(new Datos(map.getNombre(), map.getCantidad()));
            }
            Reportes reportes = new Reportes();
            reportes.generarReporteDelDia(lista, "Asistencias por Caracteristica");
        }
    }

    public void estadisticosDos(Cola colax) {
        List<Tickets> ticketsr = obtenerUtilList(colax);
        if (ticketsr != null && !ticketsr.isEmpty()) {
            List<MapaEstadist> maps = new ArrayList<>();

            for (Tickets ticket : ticketsr) {
                if (maps.isEmpty()) {
                    maps.add(new MapaEstadist(ticket.getTipoTransac().getId(), 1, ticket.getTipoTransac().getNombre()));
                } else {
                    int x = 0;
                    List<MapaEstadist> maps2 = maps;
                    boolean busc = true;
                    for (MapaEstadist mp : maps) {
                        if (mp.getNombre().equals(ticket.getTipoTransac().getNombre())) {
                            maps2.set(x, new MapaEstadist(mp.getId(), mp.getCantidad() + 1, ticket.getTipoTransac().getNombre()));
                            busc = false;
                        }
                        x++;
                    }
                    maps = maps2;
                    if (busc) {
                        maps.add(new MapaEstadist(ticket.getTipoTransac().getId(), 1, ticket.getTipoTransac().getNombre()));
                    }
                }
            }
            List<Datos> lista = new ArrayList<>();
            for (MapaEstadist map : maps) {
                lista.add(new Datos(map.getNombre(), map.getCantidad()));
            }
            Reportes reportes = new Reportes();
            reportes.generarReporteDelDia(lista, "Asistencias por Tipo de Transaccion");
        }
    }

}
