package proyectocolas;

import java.util.Random;
import java.util.Calendar;
import java.util.Random;

public class ClienteRandom {

    String nombres[] = {"José", "Manuel", "María", "Carmen", "Jesús ", "Antonio", "Cristina", "Jordi", "Mikel", "Javier", "Francisco ", "Mohamed", "Lucas", "Hugo", "Isabel", "Pablo", "Ana", "Lucía", "Antonia",
        "Dolores", "Laura", "Mario", "David", "Marcos", "Daniel"};
    String apellidos[] = {"Acosta", "Castellanos", "Domínguez", "Correa", "Enríquez", "Estrada", "Alayón", "Falcón",
        "Ferreira", "Figueras", "Galán", "Gallegos", "Gillén", "Gómez", "Ibarra", "Lafuente", "Llano", "Lobo", "López", "Machado", "Martínez", "Navarro", "Ochoa", "Peraza", "Quijada"};

    String condiciones[] = {"Cliente", "Tercera edad", "Tercera edad", "Embarazada", "Discapacitado"};
    String tipoTr[] = {"Apertura de Cuenta", "Deposito", "Retiro", "Pago Recibos", "WesternUnion", "Empresa"};

    String nombre, apellido, condicion, tipoTrans;
    int edad;
    Random tomar = new Random();

    public ClienteRandom() {
            
    nombre  = nombres[tomar.nextInt(25)];
    apellido  = apellidos[tomar.nextInt(25)];
    condicion  = condiciones[tomar.nextInt(5)];
    tipoTrans  = tipoTr[tomar.nextInt(6)];
    edad=tomar.nextInt(90)+18;
        
        
    }
    
   


}
