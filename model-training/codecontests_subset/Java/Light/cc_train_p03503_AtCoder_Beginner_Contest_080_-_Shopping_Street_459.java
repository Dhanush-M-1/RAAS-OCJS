import java.util.*;
import static java.lang.Integer.*;
import static java.lang.Long.*;
import static java.lang.Math.*;
import static java.lang.System.*;

public class Main {
	public static int M = 10;
	public static void main(String[] args) {
		int i,j,k;
		Scanner sc = new Scanner(in);
		int n = parseInt(sc.next());
		int[] f = new int[n];
		for (i = 0; i < n; i++) {
			for (j = 0; j < M; j++) {
				f[i] += parseInt(sc.next())<<j;
			}
//			out.printf("%x%n", f[i]);
		}
		int[][] p = new int[n][M+1];;
		for (i = 0; i < n; i++) {
			for (j = 0; j <= M; j++) {
				p[i][j] = parseInt(sc.next());
			}
		}
		sc.close();
		int max = -1000000000 - 1;
		for (i = 1; i < 1024; i++) {
			int tmp=0;
			for (j = 0; j < n; j++) {
				tmp += p[j][bitCount(f[j]&i)];
			}
			if(tmp>max)max=tmp;
		}
		out.println(max);
	}
}
