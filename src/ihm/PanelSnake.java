package ihm;

import controleur.Controleur;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Point;

import javax.swing.JPanel;

public class PanelSnake extends JPanel implements KeyListener
{
    private final int TAILLE_CARRE = 40;

    private Controleur ctrl;

    public PanelSnake(Controleur ctrl)
    {
        this.ctrl = ctrl;
        this.setBackground(Color.BLACK);

        this.setFocusable(true);
        this.requestFocus();
        this.addKeyListener(this);
    }

    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        g.setColor(Color.GREEN);

        for (Point p : this.ctrl.getSnake())
        {
            g.fillRect(p.y * this.TAILLE_CARRE, p.x * this.TAILLE_CARRE, this.TAILLE_CARRE, this.TAILLE_CARRE);
        }

        g.setColor(new Color(0, 105, 8));
        Point tete = this.ctrl.getSnake().get(0);
        g.fillRect(tete.y * this.TAILLE_CARRE, tete.x * this.TAILLE_CARRE, this.TAILLE_CARRE, this.TAILLE_CARRE);

        g.setColor(Color.RED);

        Point pomme = this.ctrl.getPomme();
        g.fillOval(pomme.y * this.TAILLE_CARRE, pomme.x * this.TAILLE_CARRE, this.TAILLE_CARRE, this.TAILLE_CARRE);
    }

    public void keyPressed(KeyEvent e)
    {
        switch (e.getKeyCode())
        {
            case KeyEvent.VK_Z -> this.ctrl.changerDir('H');
            case KeyEvent.VK_S -> this.ctrl.changerDir('B');
            case KeyEvent.VK_Q -> this.ctrl.changerDir('G');
            case KeyEvent.VK_D -> this.ctrl.changerDir('D');
            case KeyEvent.VK_SPACE -> 
            {
                this.ctrl.finJeu();
                this.ctrl.lancerJeu();
            }
        }
    }

    public void keyReleased(KeyEvent e) {}


    public void keyTyped(KeyEvent e) {}

}