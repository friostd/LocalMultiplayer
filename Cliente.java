package JAVARuntime;

import java.net.Socket;
import java.io.IOException;

public class Cliente extends Component {
	
	public static Socket cliente;
	public int porta = 2020;
	
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
