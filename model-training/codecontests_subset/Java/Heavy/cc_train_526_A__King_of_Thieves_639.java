import java.util.Scanner;

public class a {
	public static void main(String[] Args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String s = sc.next();
		boolean res = false;
		for(int k = 0; k < n; k++){
			for (int j = k+1; s.charAt(k)=='*' && j < n; j++){
				if (s.charAt(j)=='*'){
					int c = 1;
					int dx = j-k;
					int tj = j;
					while(c < 5 && tj < n && s.charAt(tj) =='*'){
						tj+= dx;
						c++;
					}
					if (c==5){
						res = true;
					}
				}
			}
		}
		System.out.println(res?"yes":"no");
	}
	public static long get(long n){
		int count = 2;
		int c = 1;
		while (n >= count) {
			n -= count;
			count *= 2;
			c++;
		}
		String ret = "";
		while (c != 0) {
			c--;
			if ((n & 1) != 0) {
				ret = "7" + ret;
			} else {
				ret = "4" + ret;
			}
			n /= 2;
		}
		return Long.parseLong(ret);
	}
}
