import java.io.DataInputStream;


import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;





public class KlientServer extends Thread{
	 static int port = 9091;
		public static ServerSocket serverSocket;
		public static Socket Client;
		public static Socket joinClient;
		public static String lastmessga="";
		public static boolean client=true;
		public static boolean waitForClient=false; 
		public  boolean end=true;
		public String oldfen="start";
		public String fen="start"; 
	@Override
	public void run() {
		if(client==true) {
		runServer();
		//end=false;
		sendAndWat();
		}
		else {
		connectToServer();
		fen = odbierz(joinClient);
		sendAndWat();}
	}
	public static void runServer() {
		try {
			serverSocket = new ServerSocket(port);
			System.out.println("Server runing");
			Client = serverSocket.accept();
			waitForClient=true;
			System.out.println("klient conected");
		    
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	
	}
	public static void connectToServer() {
		try {
			joinClient = new Socket("localhost", port);
			System.out.println("Polaczenie nawiazane");
			DrawElements.cl=joinClient;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}
	public void sendAndWat() {

		if (client != true) {
			while (true) {

				if (end != true) {
					nadaj(joinClient, fen);

					System.out.println(fen + " rowny k");
					fen = odbierz(joinClient);
					Board.fen=fen;
					end = true;
				} else {

					oldfen = fen;
					System.out.println(fen + " nierowny");
				}
			}

		} else {
			while (true) {

				if (end != true) {
					nadaj(Client, fen);
					System.out.println(fen + " rowny s");
					fen = odbierz(Client);
					Board.fen=fen;
					end = true;
				} else {

					oldfen = fen;

				}

			}
		}

	}
	public static synchronized void nadaj(Socket cl,String fen) {
		
		DrawElements.setWait(true);
		try {
			
			DataOutputStream out;
			OutputStream out_sock;
			out_sock = cl.getOutputStream();
			out = new DataOutputStream(out_sock);
			out.writeUTF(fen);
		} catch (IOException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}
	public synchronized static String odbierz(Socket cl) {
		String  v=null;
		
		DrawElements.setWait(false);
		try {
			
			DataInputStream in;
			InputStream in_sock;
			in_sock = cl.getInputStream();
			in = new DataInputStream(in_sock);
			
			v = in.readUTF();
			
		} catch (IOException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}

		if(v!=null)
			return v;
		else
			return null;
	}
	

}
