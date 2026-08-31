import java.util.Scanner;

public class CR58_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int j = 1; j <= t; j++) {
			long l = sc.nextLong();
			long r = sc.nextLong();
			long d = sc.nextLong();
			if(d==1 && l==1) {
				System.out.println(r+1);
				continue;
			}
			if(d<l || d>r) {
				System.out.println(d);
			} else {
				long mid = d*2;
				if(mid>r) {
					System.out.println(mid);
					continue;
				}
				long diff = r-mid;
				long rem = diff%d;
				long ldiff = d - rem;
				long ans = r+ldiff;
				if(ans==r) ans = d+r;
				System.out.println(ans);
			}
		}
	}

}
