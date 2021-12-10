import java.awt.Point;

public class King extends Pieces {
    public static boolean Check=false;
	public King(char name, int x, int y) {
		super(name, x, y);
		// TODO Auto-generated constructor stub
	}
	public void move(char[][] board) {
		
		if (posX  >= 0 && posX<= 7 && posY >= 0 && posY <= 7) {
			
			if(posX-1 >= 0 ) {
				Pieces nextPieces0 = Board.getPieces(posX - 1, posY);
				if(board[posX - 1][posY] =='0'||(nextPieces0!=null&& nextPieces0.color!=this.color))
				legalsMoves.add(new Point(posY , posX - 1));
			}
			
			if(posX+ 1<= 7) {
				Pieces nextPieces1 = Board.getPieces(posX + 1, posY);
				if(board[posX + 1][posY] =='0'||(nextPieces1!=null&& nextPieces1.color!=this.color))
				legalsMoves.add(new Point(posY , posX +1));
			}
			
			if(posY -1>= 0 ) {
				Pieces nextPieces2 = Board.getPieces(posX , posY-1);
				if(board[posX ][posY-1] =='0'||(nextPieces2!=null&& nextPieces2.color!=this.color))
				legalsMoves.add(new Point(posY-1 , posX ));
			}
			
			if(posY+ 1<= 7 ) {
				Pieces nextPieces3 = Board.getPieces(posX , posY+1);
				if(board[posX ][posY+1] =='0'||(nextPieces3!=null&& nextPieces3.color!=this.color))
				legalsMoves.add(new Point(posY+1 , posX ));
			}
			
			if(posX-1 >= 0 &&posY -1>= 0) {
				Pieces nextPieces4 = Board.getPieces(posX - 1, posY-1);
				if(board[posX - 1][posY-1]=='0' ||(nextPieces4!=null&& nextPieces4.color!=this.color))
				legalsMoves.add(new Point(posY-1 , posX - 1));
			}
			if(posX-1 >= 0 &&posY +1<= 7 ) {
				Pieces nextPieces6 = Board.getPieces(posX - 1, posY+1);
				if(board[posX - 1][posY+1]=='0' ||(nextPieces6!=null&& nextPieces6.color!=this.color))
				legalsMoves.add(new Point(posY+1 , posX -1));
			}
			
			if(posX+ 1<= 7 &&posY+ 1<= 7 ) {
				Pieces nextPieces5 = Board.getPieces(posX + 1, posY+1);
				if(board[posX + 1][posY+1] =='0'||(nextPieces5!=null&& nextPieces5.color!=this.color))
				legalsMoves.add(new Point(posY+1 , posX +1));
			}
			if(posX+ 1<= 7 &&posY -1>= 0 ) {
				Pieces nextPieces7 = Board.getPieces(posX + 1, posY-1);
				if(board[posX + 1][posY-1] =='0'||(nextPieces7!=null&& nextPieces7.color!=this.color))
				legalsMoves.add(new Point(posY+1 , posX -1));
			}
			
		}
		
	}

}
