/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocolas;

import javax.swing.JOptionPane;

/**
 *
 * @author pc
 */
public class Principal {

    public static Inicio frmI;
    public static formColaBanco frmR;
    public static formCaja frmC;

//    public static Cliente Principio = new Cliente();
//    public static Cliente Final = new Cliente();
    // public static  Cola cola = new Cola();
    public static void main(String[] args) {
        // TODO code application logic here
        Principal.frmI = new Inicio();
        Principal.frmR = new formColaBanco();
        //Principal.frmC = new formCaja();
        Principal.frmI.setVisible(true);

    }

}
