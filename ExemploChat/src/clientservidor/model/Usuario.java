package clientservidor.model;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author lucasirc
 */
public class Usuario {

    private String nome;
    private Socket socket;
    private PrintWriter saida;

    public Usuario() {
    }

    public Usuario(String nome, Socket socket) {
        this.nome = nome;
        this.socket = socket;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
        
        try {
        saida = new PrintWriter(new OutputStreamWriter(socket.getOutputStream())
                );
        } catch (Exception e ) {
            throw new RuntimeException("erro ao criar saida do usuario");
        }
    }

    public PrintWriter getSaida() {
        return saida;
    }

    public void setSaida(PrintWriter saida) {
        this.saida = saida;
    }
}
