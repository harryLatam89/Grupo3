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
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import proyectocolas.reporte.Datos;
import proyectocolas.reporte.DatosJasperAdapter;

/**
 *
 * @author T420S
 */
public class Reportes {

    public void generarReporteDelDia(List<Datos> datos) {
        try {
            JasperReport report = JasperCompileManager.compileReport("src/proyectocolas/reporte/reporte.jrxml");
            System.out.println("jaaperreport");
            // se invocan parametros para ser insertados en el reporte
            Map<String, Object> parametros = new HashMap<String, Object>();
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

}
