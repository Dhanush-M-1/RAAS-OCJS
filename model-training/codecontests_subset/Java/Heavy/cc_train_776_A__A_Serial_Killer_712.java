import java.util.*;
import java.io.PrintWriter;

public class A776 implements Runnable {
	private Scanner in = new Scanner(System.in);
	private PrintWriter out = new PrintWriter(System.out);
	private int n,size;

	String firstNames;

	String s1,s2;

	String names [];

	private int ans = 0;
	
	public static void main(String[] args) {
		new Thread(new A776()).start();
	}

	private void read() {
		s1 = in.next();
		s2 = in.next();

		n = in.nextInt();
		size = n*2;
		names = new String[size];

		for(int i = 0; i < size; i++) {

			names[i] = in.next();

		}


	}

	private void solve() {
		out.println(s1 + " " + s2);

		for(int i = 0; i < size; i+=2) {

			if(names[i].equals(s1)) {
				s1 = names[i+1];	
			} else if(names[i].equals(s2)) {
				s2 = names[i+1];
			}

			out.println(s1 + " " + s2);

		}

	}


	private void write() {
		
	}


	public void run() {
		read();
		solve();
		write();
		out.close();
	} 
}