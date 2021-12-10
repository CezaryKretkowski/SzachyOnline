import java.awt.Point;
import java.util.LinkedList;

public class Pieces {
	protected char name;
	protected boolean color;
	protected int posX, posY;
	public LinkedList<Point> legalsMoves;

	public Pieces(char name, int x, int y) {
		this.name = name;
		this.posX = x; 
		this.posY = y;
		legalsMoves = new LinkedList<Point>();
		if (name == 'P' || name == 'R' || name == 'K' || name == 'N' || name == 'Q' || name == 'B')
			color = true;
		else
			color = false;
	}
 
	public void setName(char name) {
		this.name = name;
	}

	public int getName() {
		return name;
	}

	public void setPosX(int x) {
		this.posX = x;
	}

	public void setPosY(int y) {
		this.posY = y;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public boolean isColor() {
		return color;
	}

	public void setColor(boolean color) {
		this.color = color;
	}

	public void clearLegalMoves() {
		legalsMoves.remove();
	}
}
