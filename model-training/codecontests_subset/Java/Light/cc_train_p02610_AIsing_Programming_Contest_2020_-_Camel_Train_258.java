import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			Main main = new Main();
			List<Number> a = new ArrayList<Number>();
			List<Number> b = new ArrayList<Number>();
			for (int j = 0; j < N; j++) {
				Number temp = main.new Number();
				temp.K = sc.nextInt();
				temp.L = sc.nextLong();
				temp.R = sc.nextLong();
				temp.sa = Math.abs(temp.L - temp.R);
				if (temp.L > temp.R) {
					temp.b = true;
					a.add(temp);
				} else {
					temp.b = false;
					b.add(temp);
				}
			}
			Collections.sort(a);
			Collections.sort(b);
			long sum = 0;
			TreeSet<Integer> set = new TreeSet<Integer>();
			for (int j=1;j<=N;j++) {
				set.add(j);
			}
			for (int j = a.size()-1; j >=0 ; j--) {
				Number temp = a.get(j);
				int k = temp.K;
				if (k>a.size()) {
					k = a.size();
				}
				sum +=temp.R;
				Integer e=set.floor(k);
				if (e!=null) {
					sum +=temp.sa;
					set.remove(e);
				}
			}
			for (int j = b.size()-1; j >=0 ; j--) {
				Number temp = b.get(j);
				int k = temp.K + 1;
				if (k<= a.size()) {
					k =  a.size()+1;
				}
				sum +=temp.L;
				Integer e=set.ceiling(k);
				if (e!=null) {
					sum +=temp.sa;
					set.remove(e);
				}
			}
			System.out.println(sum);
		}
	}

	public class Number implements Comparable<Number> {
		int K;
		long L;
		long R;
		long sa;
		boolean b;

		@Override
		public int compareTo(Number o) {
			if (this.sa > o.sa) {
				return 1;
			} else if (this.sa == o.sa ) {
				return 0;
			}
			return -1;
		}
	}
}