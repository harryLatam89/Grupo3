

package proyectocolas.modelos;

public class Cliente {

    String nombre;
    String apellido;
    int edad;
    int prioridad=0;
    String numerodeTicket, condicion, tipoTransaccion;
    int correlativo;
    Cliente siguiente;

    


    public Cliente(String nombre, String apellido, int edad, String condic, String tipoTransac,String numeroticket) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.condicion = condic;
        this.tipoTransaccion = tipoTransac;

        this.prioridad = prioridad(condic);
        this.numerodeTicket = numeroticket;
        this.siguiente=null;
      
    }

    public Cliente() {
        
        
        
        
    } 
    
    
    public final int prioridad(String condicion) {
        int valor = 0;

        
        switch (condicion) {
            case "Discapacitado":
                valor = 1;
               
                break;

            case "Tercera edad":
                valor = 2;
                break;

            case "Embarazada":
                valor = 3;
                break;
            case "Cliente":
                valor =4;           

                break;
        }

        
        return valor;
    }

    public void setSiguiente(Cliente sig) {
        this.siguiente = sig;
    }

    public Cliente getSiguiente() {
        return siguiente;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public int getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(int correlativo) {
        this.correlativo = correlativo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNumerodeTicket() {
        return numerodeTicket;
    }

    public String getCondicion() {
        return condicion;
    }

    public String getTipoTransaccion() {
        return tipoTransaccion;
    }


    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", prioridad=" + prioridad + ", numerodeTicket=" + numerodeTicket + ", condicion=" + condicion + ", tipoTransaccion=" + tipoTransaccion + ", correlativo=" + correlativo + ", siguiente=" + siguiente + '}';
    }

   
 

}
