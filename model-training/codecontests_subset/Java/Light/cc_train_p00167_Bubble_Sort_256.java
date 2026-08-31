import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

	static Scanner scan = new Scanner(System.in);
	static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) {
		while(true){
			int n = si(),cnt = 0;
			if(n==0) break;
			int[] ary = new int[n];
			for (int i = 0; i < n ; i++) {
				ary[i] = si();
			}
			for (int i = n-1; i > 0; i--) {
				for (int j = 0; j < i ; j++) {
					int tmp;
					if(ary[j+1]<ary[j]){
						tmp = ary[j+1];
						ary[j+1]=ary[j];
						ary[j] = tmp;
						cnt++;
					}
				}
			}
			out.println(cnt);
		}
		out.flush();
	}

	static int si() {
		return Integer.parseInt(scan.next());
	}
}