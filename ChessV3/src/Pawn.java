import java.awt.Point;
import java.util.LinkedList;

public class Pawn extends Pieces {

	public Pawn(char name, int x, int y) {
		super(name, x, y);
		// TODO Auto-generated constructor stub
	}

	public void move(char[][] board) {
		// System.out.println(board[posX-1][posY+1] + " 1");
		int kolor;
		
		
		
		if (posX - 1 >= 0 && posX <= 7 && posY >= 0 && posY <= 7) {
			if (color == true) { 

				if (board[posX - 1][posY] == '0')
					legalsMoves.add(new Point(posY, posX - 1));

				if (posY + 1 < 8 && posX + 1 < 8 && posX - 1 >= 0) {
					Pieces nextPieces0 = Board.getPieces(posX - 1, posY + 1);
					if (nextPieces0 != null && nextPieces0.color != this.color)
						legalsMoves.add(new Point(posY + 1, posX - 1));
				}
				if (posY - 1 >= 0 && posX + 1 < 8 && posX - 1 >= 0) {
					Pieces nextPieces1 = Board.getPieces(posX - 1, posY - 1);
					if (nextPieces1 != null && nextPieces1.color != this.color)
						legalsMoves.add(new Point(posY - 1, posX - 1));
					
				}
				if(posX==6&&board[posX - 2][posY] == '0') {
					legalsMoves.add(new Point(posY, posX - 2));
				}

			} else if (color == false) {

				if (board[posX + 1][posY] == '0')
					legalsMoves.add(new Point(posY, posX + 1));

				if (posY + 1 < 8 && posX + 1 < 8 && posX - 1 >= 0) {
					Pieces nextPieces0 = Board.getPieces(posX + 1, posY + 1);
					if (nextPieces0 != null && nextPieces0.color != this.color)
						legalsMoves.add(new Point(posY + 1, posX + 1));
				}
				if (posY - 1 >= 0 && posX + 1 < 8 && posX - 1 >= 0) {
					Pieces nextPieces1 = Board.getPieces(posX + 1, posY - 1);
					if (nextPieces1 != null && nextPieces1.color != this.color)
						legalsMoves.add(new Point(posY - 1, posX + 1));
				}
				if(posX==1&&board[posX + 2][posY] == '0') {
					legalsMoves.add(new Point(posY, posX + 2));
				}

			}
		}
	}
}
