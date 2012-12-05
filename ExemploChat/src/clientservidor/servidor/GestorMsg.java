package clientservidor.servidor;

import clientservidor.model.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lucasirc
 */
public class GestorMsg {
    
    private List<Usuario> usuarios = new ArrayList<Usuario>();
    
    public void add(Usuario user) {
        usuarios.add(user);
        
    }
    
    public synchronized void enviar(Usuario u, String msg) {
        System.out.println("########## Enviando");
        for ( Usuario aux :  usuarios) {
            aux.getSaida().println( u.getNome() + " diz: " + msg );
            aux.getSaida().flush();
            System.out.println("Envia de " + u.getNome() + " para " + aux.getNome());
            
            
        }
        System.out.println("########## Enviado");
    }
}
