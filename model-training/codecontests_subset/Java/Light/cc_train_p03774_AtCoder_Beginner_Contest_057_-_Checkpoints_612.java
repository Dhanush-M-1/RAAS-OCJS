import java.util.*;
import static java.lang.Math.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), M = sc.nextInt();
		int[] a = new int[N];
		int[] b = new int[N];
		int[] c = new int[M];
		int[] d = new int[M];
		for(int i = 0; i < N; i++) {
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
		}
		for(int j = 0; j < M; j++) {
			c[j] = sc.nextInt();
			d[j] = sc.nextInt();
		}
		for(int i = 0; i < N; i++) {
			int min = 0, man = 0,minIndex=0;
			for(int j = 0; j < M; j++) {
				man = abs(a[i] - c[j]) + abs(b[i] - d[j]);
				if(man < min || j == 0) {
					min = man;
					minIndex = j;
					//System.out.println(man);
				}
				man = 0;
			}
			System.out.println(minIndex + 1);
		}
	}

}