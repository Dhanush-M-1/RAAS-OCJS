import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String N = sc.next();
		int K = sc.nextInt();
		int digit = N.length();
		int MAX = digit+1;
		long[][] com = new long[MAX][MAX];
		for(int i = 0; i < MAX; i++)
			com[i][0] = 1;
		for(int i = 1; i < MAX; i++)
			for(int j = 1; j <= i; j++)
				com[i][j] = com[i-1][j-1] + com[i-1][j];
		boolean ok = true;
		if(digit < K)
			ok = false;
		if(N.equals("10") && K == 2)
			ok = false;
		if(digit == 3 && K == 3)
			if(Integer.parseInt(N) < 111)
				ok = false;
		if(!ok) {
			System.out.println(0);
			return;
		}
		long ans = com[digit-1][K]*(long)Math.pow(9, K);
		ans += (Character.getNumericValue(N.charAt(0))-1) * com[digit-1][K-1] * (long)Math.pow(9, K-1);
		if(K == 1)
			ans++;
		else if(K == 2) {
			for(int i = 1; i < digit; i++) {
				int x = Character.getNumericValue(N.charAt(i));
				if(x != 0) {
					ans += x;
					ans += (digit-i-1)*9;
					break;
				}
			}
		}
		else {
			for(int i = 1; i < digit; i++) {
				int x = Character.getNumericValue(N.charAt(i));
				if(x != 0) {
					ans += com[digit-i-1][2] * 9 * 9;
					ans += (x-1) * (digit-i-1) * 9;
					for(int j = i+1; j < digit; j++) {
						int y = Character.getNumericValue(N.charAt(j));
						if(y != 0) {
							ans += y;
							ans += (digit-j-1) * 9;
							break;
						}
					}
				break;
				}		
			}
		}
		System.out.println(ans);

	}

}