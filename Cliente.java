package JAVARuntime;

import java.util.*;
import java.net.*;
import java.io.*;

public class Cliente extends Component { 

    public static Socket cliente;
    public int porta;
    

    public void start() {
        try {
        	    cliente = new Socket("localhost", porta);
        	    Console.log("Servidor Conectado");
        	}
        	catch(IOException ex){
        	    Console.log("Erro " + ex);
        	}
        
    }

    public void repeat() {
        
    }

}
