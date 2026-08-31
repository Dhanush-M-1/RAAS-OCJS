import java.io.PrintWriter;
import java.util.Scanner;

public class A {
	
	public static void main(String [] args){
		Scanner cin = new Scanner(System.in);
		PrintWriter cout = new PrintWriter(System.out);
		int N = cin.nextInt();
		int []h = new int[N], a = new int[N];
		for (int i=0;i<N;++i){
			h[i] = cin.nextInt();
			a[i] = cin.nextInt();
		}
		int cnt = 0;
		for (int i=0;i<N;++i){
			for (int j=0;j<N;++j)if (h[i] == a[j])cnt++;
		}
		cout.println(cnt);
		cout.flush();
	}

}