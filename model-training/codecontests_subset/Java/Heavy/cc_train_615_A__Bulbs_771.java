

import java.util.Scanner;
import java.io.PrintWriter;

public class Bulbs implements Runnable {
	private Scanner in = new Scanner(System.in);
	private PrintWriter out = new PrintWriter(System.out);

	
	private int[] arr;
	private String ans;

	public static void main(String[] args) {
		new Thread(new Bulbs()).start();
	}

	private void read() {
		int buttons = in.nextInt();
		int bulbs = in.nextInt();
		arr = new int[bulbs];
		for (int i = 0; i < buttons; i++) {
			int num = in.nextInt();
			for (int j = 0; j < num; j++)
				arr[in.nextInt()-1] = 1;
		}
	}

	private void solve() {
		for(int i=0;i<arr.length;i++){
			if(arr[i]==0){
				ans= "NO";
				break;
			}
			else{
				ans="YES";
			}
		}
	}

	private void write() {
		out.println(ans);
	}

	public void run() {
		read();
		solve();
		write();
		out.close();
	}
}
