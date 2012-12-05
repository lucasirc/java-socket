package clientservidor.servidor;

import clientservidor.model.Usuario;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author lucasirc
 */
public class ServidorThread extends Thread {

    private static GestorMsg gestor = new GestorMsg();
    private Usuario usu;

    public ServidorThread(Socket it) {
        usu = new Usuario();
        usu.setSocket(it);

    }

    public void run() {
        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(usu.getSocket().getInputStream()));

            String nome = reader.readLine();
            System.out.println("Nome: " + nome);
            usu.setNome(nome);

            System.out.println("Adicionado usuario.");
            gestor.add(usu);
            while (true) {
                String msg = reader.readLine();
                System.out.println("Recebido mensagem: " + usu.getNome() + msg);
                gestor.enviar(usu, msg);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
