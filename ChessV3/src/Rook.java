import java.awt.Point;

public class Rook extends Pieces {

	public Rook(char name, int x, int y) {
		super(name, x, y);
		// TODO Auto-generated constructor stub
	}
	public void move(char[][] board) {
		move1(board);
		move2(board);
		move3(board);
		move4(board);

	}

	private void move1(char[][] board) {
		int i = posX+1 ;
		int j = posY;
		
		findmoves:while (i <= 7 ) {
			
				Pieces nextPieces0 = Board.getPieces(i, j);
				if(nextPieces0 != null &&nextPieces0.color == this.color) break findmoves;
				if (nextPieces0 == null )
					legalsMoves.add(new Point(j,i));
				if(nextPieces0 != null &&nextPieces0.color != this.color) {
					legalsMoves.add(new Point(j,i));
					break findmoves;
				}	
			     
			i++;
			
		}
	}

	private void move2(char[][] board) {

		int i = posX-1 ;
		int j = posY;
		
		findmoves:while (i >= 0 ) {
			
				Pieces nextPieces0 = Board.getPieces(i, j);
				if(nextPieces0 != null &&nextPieces0.color == this.color) break findmoves;
				if (nextPieces0 == null )
					legalsMoves.add(new Point(j,i));
				if(nextPieces0 != null &&nextPieces0.color != this.color) {
					legalsMoves.add(new Point(j,i));
					break findmoves;
				}	
			
			i--;
			
		}
	}
	private void move3(char[][] board) {
		int i = posX ;
		int j = posY-1;
		System.out.println((posX-1)+""+(posY-1));
		findmoves:while (j >= 0) {
			    
				Pieces nextPieces0 = Board.getPieces(i, j);
			    if(nextPieces0 != null &&nextPieces0.color == this.color) break findmoves;
				if (nextPieces0 == null )
					legalsMoves.add(new Point(j,i));
				if(nextPieces0 != null &&nextPieces0.color != this.color) {
					legalsMoves.add(new Point(j,i));
					break findmoves;
				}	
			
			
			j--;
		}
	}
	private void move4(char[][] board) {
		int i = posX;
		int j = posY+1;
		
		findmoves:while ( j <= 7) {
			
				Pieces nextPieces0 = Board.getPieces(i, j);
				if(nextPieces0 != null &&nextPieces0.color == this.color) break findmoves;
				if (nextPieces0 == null )
					legalsMoves.add(new Point(j,i));
				if(nextPieces0 != null &&nextPieces0.color != this.color) {
					legalsMoves.add(new Point(j,i));
					break findmoves;
				}	
			
			
			j++;
		}
	}

}
