/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocolas.datos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import proyectocolas.modelos.Caracteristicas;
import proyectocolas.modelos.Cola;
import proyectocolas.modelos.Tickets;
import proyectocolas.modelos.TiposColas;
import proyectocolas.modelos.Transacciones;

/**
 *
 * @author T420S
 */
public class DataGlobal {

    public static Cola cola1;
    public static Cola colaEstadistica1;
    public static List<Caracteristicas> caracteristicas;
    public static List<TiposColas> tiposColas;
    public static List<Tickets> tickets;
    public static List<Transacciones> transacciones;

    public static List<Integer> recolectTransacciones;
    public static List<Integer> recolectcaracteristicas;
    
    public static List<Caracteristicas> caracteristicasConfig;

    public static List<Caracteristicas> caracteristicasIniciales() {
        List<Caracteristicas> list = new ArrayList<>();
        list.add(new Caracteristicas("Cliente", " descripcion.."));
        list.add(new Caracteristicas("Tercera edad", " descripcion.."));
        list.add(new Caracteristicas("Tercera edad", " descripcion.."));
        list.add(new Caracteristicas("Embarazada", " descripcion.."));
        list.add(new Caracteristicas("Discapacitado", " descripcion.."));
        return list;
    }

    public static List<Transacciones> transaccionesIniciales() {
        List<Transacciones> list = new ArrayList<>();
        list.add(new Transacciones("Apertura de Cuenta"));
        list.add(new Transacciones("Deposito"));
        list.add(new Transacciones("Retiro"));
        list.add(new Transacciones("Pago Recibos"));
        list.add(new Transacciones("WesternUnion"));
        list.add(new Transacciones("Empresa"));
        return list;
    }

    public static List<TiposColas> tiposColasIniciales() {
        List<TiposColas> list = new ArrayList<>();
        List<Caracteristicas> list2 = caracteristicas;
        if (list2 == null) {
            list2 = DataGlobal.caracteristicasIniciales();
            DataGlobal.caracteristicas = DataGlobal.caracteristicasIniciales();
        }
        Random ram = new Random();
        if (!list2.isEmpty()) {
            List<Caracteristicas> list3 = new ArrayList<>();
            list3.add(list2.get(ram.nextInt(list2.size())));
            list3.add(list2.get(ram.nextInt(list2.size())));
            list.add(new TiposColas('A', list3));
            list3 = new ArrayList<>();
            list3.add(list2.get(ram.nextInt(list2.size())));
            list3.add(list2.get(ram.nextInt(list2.size())));
            list.add(new TiposColas('B', list3));
            list3 = new ArrayList<>();
            list3.add(list2.get(ram.nextInt(list2.size())));
            list3.add(list2.get(ram.nextInt(list2.size())));
            list.add(new TiposColas('C', list3));
            list3 = new ArrayList<>();
            list3.add(list2.get(ram.nextInt(list2.size())));
            list3.add(list2.get(ram.nextInt(list2.size())));
            list.add(new TiposColas('D', list3));
        }
        return list;
    }

}
