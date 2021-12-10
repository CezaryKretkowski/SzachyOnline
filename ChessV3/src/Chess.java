import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class Chess extends JFrame {

	private JPanel contentPane;
	private static JFrame frame;
	public static boolean palydColor=true;

	/**
	 * Launch the application.
	 */ 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Chess window = new Chess();
					window.frame.setVisible(true);
					menuDialog() ;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	} 
     
	public static void menuDialog() {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			Menu dialog = new Menu();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Create the frame.
	 */
	public Chess() {
		initialize();

	}

	private void initialize() {

		frame = new JFrame();

		frame.setBounds(100, 100, 816, 839);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(new DrawElements());
		
		// Board newB=new Board();
		// newB.fenToTab();
		// newB.printBoard(newB.board);

	}

}
