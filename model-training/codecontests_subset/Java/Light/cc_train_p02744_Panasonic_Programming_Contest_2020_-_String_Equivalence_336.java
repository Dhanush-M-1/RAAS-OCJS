import java.io.PrintWriter;
import java.util.*;

public class Main {
	static int N;
	static PrintWriter pw;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		pw = new PrintWriter(System.out);
		
		N = sc.nextInt();

		char[] str = new char[N];
		print(str, 0, 0);
		
		pw.close();
		sc.close();
	}
	
	static void print(char[] str, int p, int m) {
		if(p==N) {
			pw.println(str);
			return;
		}
		for(int i=0; i<m+1; i++) {
			str[p]=(char)('a'+i);
			print(str, p+1, Math.max(m, i+1));
		}
	}
}
