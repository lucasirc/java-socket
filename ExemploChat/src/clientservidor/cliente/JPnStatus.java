package clientservidor.cliente;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author lucasirc
 */
public class JPnStatus extends JPanel{

    boolean ativo = false;

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        if (ativo) {
            g2d.setColor(Color.GREEN);
        } else {
            g2d.setColor(Color.red);
        }
        g.fillOval(0, 0, 50, 50);
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    
    
    
}
