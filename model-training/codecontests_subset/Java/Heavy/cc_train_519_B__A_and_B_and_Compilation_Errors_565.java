import java.util.*;
import java.io.PrintWriter;

public class B519 implements Runnable {
	private Scanner in = new Scanner(System.in);
	private PrintWriter out = new PrintWriter(System.out);
	private int n;
	private int a1[];
	private int a2[];
	private int a3[];

	private int ans;
	
	public static void main(String[] args) {
		new Thread(new B519()).start();
	}

	private void read() {
		n = in.nextInt();

		a1 = new int[n];
		a2 = new int[n-1];
		a3 = new int[n-2];

		for(int i = 0; i < n; i++){
			a1[i] = in.nextInt();
		}

		for(int i = 0; i < n-1; i++){
			a2[i] = in.nextInt();
		}

		for(int i = 0; i < n-2; i++){
			a3[i] = in.nextInt();
		}
		
	}

	private void solve() {
		Arrays.sort(a1);
		Arrays.sort(a2);
		Arrays.sort(a3);

		boolean bool = true;


		for(int i = 0; i < a1.length; i++){
			for(int j = i; j < a2.length; j++){
				if(a1[i] == a2[j]) {
					bool = false;
					break;
				}
			}
			if(bool){
				out.println(a1[i]);
				break;
			}
			bool = true;
		}

		bool = true;
		for(int i = 0; i < a2.length; i++){
			for(int j = i; j < a3.length; j++){
				if(a2[i] == a3[j]) {
					bool = false;
					break;
				}
			}
			if(bool){
				out.println(a2[i]);
				break;
			}
			bool = true;
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