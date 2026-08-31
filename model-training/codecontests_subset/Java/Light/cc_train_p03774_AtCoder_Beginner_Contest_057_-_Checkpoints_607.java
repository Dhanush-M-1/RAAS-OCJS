import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int N,M;
		ArrayList<Integer> a = new ArrayList<Integer>();
		ArrayList<Integer> b = new ArrayList<Integer>();
		ArrayList<Integer> c = new ArrayList<Integer>();
		ArrayList<Integer> d = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		for(int i = 0; i < N; i++) {
			a.add(sc.nextInt());
			b.add(sc.nextInt());
		}

		for(int i = 0; i < M; i++) {
			c.add(sc.nextInt());
			d.add(sc.nextInt());
		}

		for(int i = 0; i < N; i++) {
			int k = 2147483647;
			int n = 0;
			for(int j = 0; j < M; j++) {
				int l = Math.abs(a.get(i) - c.get(j)) + Math.abs(b.get(i) - d.get(j));
				if(l < k) {
					k = l;
					n = j + 1;
				}
			}
			System.out.println(n);
		}

		sc.close();
	}
}