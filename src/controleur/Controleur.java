package controleur;

import metier.Snake;
import ihm.FrameSnake;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Timer;
import java.awt.Point;
import ihm.FrameSnake;

public class Controleur implements ActionListener
{
    private Timer timer;
    private FrameSnake ihm;
    private Snake metier;

    public Controleur()
    {
        this.metier = new Snake();
        this.ihm = new FrameSnake(this);
    }

    public void lancerJeu()
    {
        this.timer = new Timer(200, this);

        timer.start();
    }

    public List<Point>  getSnake()         { return this.metier.getSnake(); }
    public Point        getPomme()         { return this.metier.getPomme(); }

    public void changerDir(char dir)
    {
        this.metier.changerDir(dir);
    }

    public void actionPerformed(ActionEvent e)
    {
        this.metier.deplacer();
        if(!this.metier.estActif())
        {
            System.out.println("GAME OVER");
            this.finJeu();
        }
        this.ihm.repaint();
    }

    public void finJeu()
    {
        if (this.timer != null)
        {
            this.timer.stop();
        }
        
        
        this.metier = new Snake();
        this.ihm.dispose();
        this.ihm = new FrameSnake(this);
    }

    public static void main(String[] args)
    {
        new Controleur();
    }
}