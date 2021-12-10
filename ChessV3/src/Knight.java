import java.awt.Point;

public class Knight extends Pieces {

	public Knight(char name, int x, int y) {
		super(name, x, y);
		// TODO Auto-generated constructor stub
	}

	public void move(char[][] board) {

		if (posY + 1 >= 0 && posX - 2 >= 0 && posX - 2 <= 7 && posY + 1 <= 7) {
			Pieces nextPieces0 = Board.getPieces(posX - 2, posY + 1);
			if (nextPieces0 == null || nextPieces0.color != this.color)
				legalsMoves.add(new Point(posY + 1, posX - 2));
		}
		if (posY - 1 >= 0 && posX - 2 >= 0 && posX - 2 <= 7 && posY - 1 <= 7) {
			Pieces nextPieces0 = Board.getPieces(posX - 2, posY - 1);
			if (nextPieces0 == null || nextPieces0.color != this.color)
				legalsMoves.add(new Point(posY - 1, posX - 2));
		} 
		if (posY + 1 >= 0 && posX + 2 >= 0 && posX + 2 <= 7 && posY + 1 <= 7) {
			Pieces nextPieces0 = Board.getPieces(posX + 2, posY + 1);
			if (nextPieces0 == null || nextPieces0.color != this.color)
				legalsMoves.add(new Point(posY + 1, posX + 2));
		}
		if (posY - 1 >= 0 && posX + 2 >= 0 && posX + 2 <= 7 && posY - 1 <= 7) {
			Pieces nextPieces0 = Board.getPieces(posX + 2, posY - 1);
			if (nextPieces0 == null || nextPieces0.color != this.color)
				legalsMoves.add(new Point(posY - 1, posX + 2));
		}
		if (posY - 2 >= 0 && posX + 1 >= 0 && posX + 1 <= 7 && posY - 2 <= 7) {
			Pieces nextPieces0 = Board.getPieces(posX + 1, posY - 2);
			if (nextPieces0 == null || nextPieces0.color != this.color)
				legalsMoves.add(new Point(posY - 2, posX + 1));
		}
		if (posY + 2 >= 0 && posX + 1 >= 0 && posX + 1 <= 7 && posY + 2 <= 7) {
			Pieces nextPieces0 = Board.getPieces(posX + 1, posY + 2);
			if (nextPieces0 == null || nextPieces0.color != this.color)
				legalsMoves.add(new Point(posY + 2, posX + 1));
		}
		
		if (posY + 2 >= 0 && posX - 1 >= 0 && posX - 1 <= 7 && posY + 2 <= 7) {
			Pieces nextPieces0 = Board.getPieces(posX - 1, posY + 2);
			if (nextPieces0 == null || nextPieces0.color != this.color)
				legalsMoves.add(new Point(posY + 2, posX - 1));
		}
		if (posY - 2 >= 0 && posX - 1 >= 0 && posX - 1 <=7 && posY - 2 <= 7) {
			Pieces nextPieces0 = Board.getPieces(posX - 1, posY -2);
			if (nextPieces0 == null || nextPieces0.color != this.color)
				legalsMoves.add(new Point(posY - 2, posX - 1));
		}
	}
}
