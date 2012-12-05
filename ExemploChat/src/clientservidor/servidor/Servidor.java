package clientservidor.servidor;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 *
 * @author lucasirc
 */
public class Servidor {
    public static void main(String[] args) throws Exception{
        ServerSocket so = new ServerSocket(4035);
        
        while (true )  {
            System.out.println("Esperando conexao ");
            Socket socket = so.accept();
            System.out.println("Conectado em " + new Date() );
            new ServidorThread(socket).start();
        }
            
        
    }
}
