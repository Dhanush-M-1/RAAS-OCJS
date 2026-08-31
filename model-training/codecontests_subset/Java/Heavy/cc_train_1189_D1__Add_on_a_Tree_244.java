import java.util.*;
import java.io.*;

public class addonatree {
	public void run() throws Exception {
		Scanner file =new Scanner(System.in);
		int times =file.nextInt();
		ArrayList<ArrayList<Integer>> adj = new ArrayList();
		for (int i= 0; i < times; i++) {
			adj.add(new ArrayList());
		}
		for (int i = 0;i  < times - 1; i++) {
			int a = file.nextInt() - 1; int b= file.nextInt() -1;
			adj.get(a).add(b);
			adj.get(b).add(a);
		}
		boolean b = true;
		for (int i=0; i < times; i++) {
			if (adj.get(i).size() ==1 && adj.get(adj.get(i).get(0)).size() == 2) {
				b = false;
				break;
			}
			else if (adj.get(i).size() == 2) {
				b = false;
				break;
			}
		}
		System.out.println( b ? "YES" : "NO");

	}

	public static void main(String[] args) throws Exception {
		new addonatree().run();
	}

}
