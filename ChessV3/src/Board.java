
public class Board {
	public static String fen;
	public static char[][] board;

	public Board() {
		board = new char[8][8];
		fen = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR";
	}

	public void setFen(String fen) {
		this.fen = fen;
	}

	public String getFen() {
		return fen;
	}

	public  void fenToTab() {
		char piece;
		int i = 0;
		int x = 0, y = 0;
		while (i < fen.length()) {
			piece = fen.charAt(i);

			if (piece == 'n' || piece == 'b' || piece == 'k' || piece == 'q' || piece == 'r' || piece == 'p'
					|| piece == 'N' || piece == 'B' || piece == 'K' || piece == 'Q' || piece == 'R' || piece == 'P') {
				board[y][x] = piece;

				x += 1;
			} else if (piece == '/') {
				y += 1;
				x = 0;
			} else if (piece >= '1' || piece <= '8') {
				int ofset = (int) piece - 48;
				for (int j = 0; j < ofset; j++) {
					board[y][x] = '0';
					x += 1;
				}
			}

			i++;
		}

	}

	public  void tabToFen() {
		String fen1 = "";
		int licznik = 0;
		for (int w = 0; w < 8; w++) {
			for (int i = 0; i < 8; i++) {
				if (board[w][i] == '0') {
					licznik = 0;
					int j = i;
					while (j < 8 && board[w][j] == '0') {
						j++;
						licznik++;
					}
					fen1 += (char) (licznik + '0');
					i = i + licznik - 1;
				} else {
					fen1 += board[w][i];
				}
			}
			fen1 += "/";
		}
		fen = fen1;

	}

	public static Pieces getPieces(int x, int y) {

		char name = board[x][y];
		if (name != '0') {
			Pieces newPiece = new Pieces(name, x, y);

			return newPiece;
		} else
			return null;
	}

	public static void printBoard(char[][] board) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}

	}
}
