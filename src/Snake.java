import java.util.List;
import java.util.ArrayList;
import java.awt.Point;

public class Snake
{
    private final static int LIG = 11;
    private final static int COL = 11;

    private List<Point> snake;
    private char orientation;

    private Point pomme;

    private boolean jeuActif;
    
    
    public Snake()
    {
        this.snake = new ArrayList<>();
        this.snake.add(new Point(6, 6));

        this.orientation = 'H'; //Haut Bas Gauche Droite (H, B, G, D)

		this.jeuActif = true;

		this.genererPomme();
    }

	public boolean deplacementPossible()
	{
		Point tete = this.snake.get(0);
		
		switch (this.orientation)
		{
			case 'H' -> 
			{
				if (tete.x == 0)
				{
					this.jeuActif = false;
					return false;
				}
				else
				{
					return true;
				}
			}
			case 'B' ->
			{
				if (tete.x == Snake.LIG - 1)
				{
					this.jeuActif = false;
					return false;
				}
				else
				{
					return true;
				}
			}
			case 'G' ->
			{
				if (tete.y == 0)
				{
					this.jeuActif = false;
					return false;
				}
				else
				{
					return true;
				}
			}
			case 'D' ->
			{
				if (tete.y == Snake.COL - 1)
				{
					this.jeuActif = false;
					return false;
				}
				else
				{
					return true;
				}
			}
			default -> { this.jeuActif = false; return false; }
		}
	}

	public void deplacer()
	{
		
		if (deplacementPossible())
		{
			Point nouvelleTete;
			Point dernier = new Point(this.snake.get(this.snake.size()-1));

			for (int i = this.snake.size()-1; i > 0;i--)
			{
				this.snake.get(i).x = this.snake.get(i-1).x;
				this.snake.get(i).y = this.snake.get(i-1).y;
			}
			
			switch (this.orientation)
			{
				case 'H' -> 
				{
					nouvelleTete = new Point(this.snake.get(0).x -1, this.snake.get(0).y);
				}
				case 'B' -> 
				{
					nouvelleTete = new Point(this.snake.get(0).x +1, this.snake.get(0).y);
				}
				case 'G' -> 
				{
					nouvelleTete = new Point(this.snake.get(0).x, this.snake.get(0).y-1);
				}
				case 'D' -> 
				{
					nouvelleTete = new Point(this.snake.get(0).x, this.snake.get(0).y+1);
				}
				default -> { return; }
			}

			for (Point p : this.snake)
			{
				if (p.equals(nouvelleTete))
				{
					this.jeuActif = false;
					return;
				}
			}

			this.snake.set(0, nouvelleTete);

			if (nouvelleTete.equals(this.pomme))
			{
				this.snake.add(dernier);
			}
		}
	}

	public void changerDir(char dir)
	{
		if (dir == 'H' || dir == 'B' || dir == 'G' || dir == 'D') { this.orientation = dir; }
	}

	public void genererPomme()
	{
		Point potentiellePomme = new Point((int) (Math.round(Math.random()*Snake.LIG)),(int) (Math.round(Math.random()*Snake.COL)) );

		for (Point p : this.snake)
		{
			if (p.equals(potentiellePomme)) 
			{ 
				potentiellePomme = new Point((int) (Math.round(Math.random()*Snake.LIG)),(int) (Math.round(Math.random()*Snake.COL)) ); 
				break;
			}
			else
			{
				continue;
			}
			
		}
	}

	
}