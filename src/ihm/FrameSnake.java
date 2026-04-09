package ihm;

import controleur.Controleur;
import javax.swing.JFrame;

public class FrameSnake extends JFrame
{
    private PanelSnake pnlJeu;
    
    public FrameSnake(Controleur ctrl)
    {
        this.setTitle("Snake");
        this.setLocation(500, 500);
        this.setSize(460, 480);

        this.pnlJeu = new PanelSnake(ctrl);
        this.add(this.pnlJeu);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.pnlJeu.requestFocusInWindow();
    }
}