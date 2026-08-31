import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		long P = sc.nextLong();
		if(N == 1) {
			System.out.println(P);
		}else {
			long m = 12/N + 1;
			int n = 1;
			int mlcm = 1;
			for(int i = 0; i < m;i++)n *= 10;
			for(int i = 1;i < n + 1;i++) {
				if(P % (Math.pow(i, N)) == 0) {
					mlcm = i;
				}
			}
			System.out.println(mlcm);
		}
	}
}
