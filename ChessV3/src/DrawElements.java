import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class DrawElements extends JPanel implements MouseListener, MouseMotionListener {
    private String lastfen; 
    public static KlientServer threds;
	private static Board newChessBoard;
	public static File imageFile;
	public static BufferedImage image;
	public LinkedList<Point> legalsMoves;
	private static char currentPieces = '0';
	private static char buffer;
	private static int x = 0, y = 0, l, H;
	private Point lastPosytion;
	public static boolean tura=true;
	public static boolean offline=true;
	public static boolean wait=true;
	public static Socket cl;
	public Pieces currentPiece;
	private boolean moveCheck=false;
	public static void setOffline(boolean t) {
		offline=t;
	}
	public static void setWait(boolean t) {
		wait=t;
	}
	public static void setTura(boolean t) {
		tura=t;
	}
	public DrawElements() {
		addMouseListener(this);
		addMouseMotionListener(this);
		setPreferredSize(new Dimension(800, 800));
		newChessBoard = new Board();
		lastPosytion = new Point();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		int startPointX = 0;
		int startPointY = 0;
		int x = startPointX;
		int y = startPointY;
		int wight = 100;
		int hight = 100;
		drawChessBoard(x, y, wight, hight, startPointX, g2d);

		drowPosytion(g2d);
		// drowMousePosytion(g2d);
		if (currentPieces != '0') {
			// drawLegalMoves(g2d);
			drawPieces(currentPieces, l, H, g2d);
		}
		drowLegaMoves(g2d);
	}

	public static void drawChessBoard(int x, int y, int wight, int hight, int startPointX, Graphics2D g2d) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {

				if ((j & 1) == 1 && (i & 1) == 1) {
					g2d.setColor(Color.WHITE);
					g2d.fillRect(x, y, wight, hight);
				} else if ((j & 1) == 1 && (i & 1) == 0) {
					g2d.setColor(new Color(0, 80, 60));
					g2d.fillRect(x, y, wight, hight);
				} else if ((j & 1) == 0 && (i & 1) == 1) {
					g2d.setColor(new Color(0, 80, 60));
					g2d.fillRect(x, y, wight, hight);
				} else if ((j & 1) == 0 && (i & 1) == 0) {

					g2d.setColor(Color.WHITE);
					g2d.fillRect(x, y, wight, hight);
				}
				x += wight;
			}
			x = startPointX;
			y = y + wight;
		}

	}

	public void drowPosytion(Graphics2D g2d) {

		char piece;
		int i = 0;
		int x = 0, y = 0;
		while (i < newChessBoard.fen.length()) {
			piece = newChessBoard.fen.charAt(i);

			if (piece == 'n' || piece == 'b' || piece == 'k' || piece == 'q' || piece == 'r' || piece == 'p'
					|| piece == 'N' || piece == 'B' || piece == 'K' || piece == 'Q' || piece == 'R' || piece == 'P') {

				drawPieces(piece, x, y, g2d);
				x += 100;
			} else if (piece == '/') {
				y += 100;
				x = 0;
			} else if (piece >= '1' || piece <= '8') {
				int ofset = (int) piece - 48;

				x += ofset * 100;
			}

			i++;
		}

	}

	public static void drawPieces(char piece, int x, int y, Graphics2D g2d) {

		String pieces = Character.toString(piece);
		if (piece == 'n' || piece == 'b' || piece == 'k' || piece == 'q' || piece == 'r' || piece == 'p') {
			if (Chess.palydColor == false)
				pieces = pieces + "W" + ".png";
			else
				pieces = pieces + "B" + ".png";
		} else if (piece == 'N' || piece == 'B' || piece == 'K' || piece == 'Q' || piece == 'R' || piece == 'P') {
			if (Chess.palydColor == false)
				pieces = pieces + "B" + ".png";
			else
				pieces = pieces + "W" + ".png";
		}
		imageFile = new File("piaces/" + pieces);
		try {
			image = ImageIO.read(imageFile);
		} catch (IOException e) {
			System.out.print("B³¹d otwarcia pliku");
		}

		g2d.drawImage(image, x, y, null, null);

	}

	public void drowLegaMoves(Graphics2D g2d) {
		g2d.setColor(new Color(50,50,50));
		if (legalsMoves != null) {
			for (Point number : legalsMoves) {

				

				g2d.fillOval(number.x * 100+34, number.y * 100+34, 30, 30);
			}
		}
		
	}

	public void fillList(char name, int x, int y) {
		System.out.print(name);
		if (name == 'P') {

			Pawn pion = new Pawn('P', x, y);

			pion.move(newChessBoard.board);
			legalsMoves = pion.legalsMoves;
		}
		if (name == 'p') {

			Pawn pion = new Pawn('p', x, y);

			pion.move(newChessBoard.board);
			legalsMoves = pion.legalsMoves;
		}
		if (name == 'N') {

			Knight knight = new Knight('N', x, y);

			knight.move(newChessBoard.board);
			legalsMoves = knight.legalsMoves;
		}
		if (name == 'n') {

			Knight knight = new Knight('n', x, y);

			knight.move(newChessBoard.board);
			legalsMoves = knight.legalsMoves;
		}
		if (name == 'B') {

			Bishop bishop = new Bishop('B', x, y);

			bishop.move(newChessBoard.board);
			legalsMoves = bishop.legalsMoves;
		}
		if (name == 'b') {

			Bishop bishop = new Bishop('b', x, y);

			bishop.move(newChessBoard.board);
			legalsMoves = bishop.legalsMoves;
		}
		if (name == 'R') {

			Rook rook = new Rook('R', x, y);

			rook.move(newChessBoard.board);
			legalsMoves = rook.legalsMoves;
		}
		if (name == 'r') {

			Rook rook = new Rook('r', x, y);

			rook.move(newChessBoard.board);
			legalsMoves = rook.legalsMoves;
		}
		if (name == 'Q') {

			Queen queen = new Queen('Q', x, y);

			queen.move(newChessBoard.board);

			legalsMoves = queen.legalsMoves;

		}
		if (name == 'q') {

			Queen queen = new Queen('q', x, y);

			queen.move(newChessBoard.board);

			legalsMoves = queen.legalsMoves;

		}
		if (name == 'K') {

			King king = new King('K', x, y);

			king.move(newChessBoard.board);

			legalsMoves = king.legalsMoves;

		}
		if (name == 'k') {

			King king = new King('k', x, y);

			king.move(newChessBoard.board);

			legalsMoves = king.legalsMoves;

		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		int h;
		int w;
		h = e.getX();
		w = e.getY();
		l = h - 50;
		H = w - 50;

		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		int h;
		int w;

		x = e.getX();
		y = e.getY();
		h = x;
		w = y;
		l = h - 50;
		H = w - 50;
		x = h / 100;
		y = w / 100;
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		int h;
		int w;
		h = e.getX();
		w = e.getY();
		y = h / 100;
		x = w / 100;
		lastPosytion.x = x;
		lastPosytion.y = y;
		lastfen=Board.fen;
		newChessBoard.fenToTab();

		buffer = newChessBoard.board[x][y];
        currentPiece=Board.getPieces(x,y);
		newChessBoard.board[x][y] = '0';
		currentPieces = buffer;
		
		fillList(currentPieces, x, y);
		newChessBoard.tabToFen();
       
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		int h;
		int w;
		boolean check = false;
		h = e.getX();
		w = e.getY();
		x = w / 100;
		y = h / 100;
		if(currentPiece!=null&&currentPiece.color==tura&&wait!=true) {
		if (legalsMoves != null)
			for (Point number : legalsMoves) {
				if (x == number.y && y == number.x)
					check = true;
			}
		if (x < 8 && y < 8 && check == true) {
			newChessBoard.fenToTab();
			newChessBoard.board[x][y] = buffer;
			currentPieces = '0';
			newChessBoard.tabToFen();
			if(lastfen.equals(Board.fen))
				moveCheck=false;
			else
				moveCheck=true;
				
			if(offline==true&&moveCheck==true)
			tura=(tura==true)?false:true;
		} else {
			newChessBoard.board[lastPosytion.x][lastPosytion.y] = buffer;
			currentPieces = '0';
			newChessBoard.tabToFen();
			if(lastfen.equals(Board.fen))
				moveCheck=false;
			else
				moveCheck=true;
		}
		}else {
			newChessBoard.board[lastPosytion.x][lastPosytion.y] = buffer;
			currentPieces = '0';
			newChessBoard.tabToFen();
			if(lastfen.equals(Board.fen))
				moveCheck=false;
			else
				moveCheck=true;
		}

		
		// fillList(buffer,x,y);
		 repaint();
	   if(offline!=true&&moveCheck==true) {
		   threds.fen=Board.fen;
	       threds.end=false;
	      
	   }
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
