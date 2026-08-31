import java.util.Scanner;
public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] res = new String[n];
		for(int i=0;i<n;i++) {
			long a = sc.nextLong();
			long b = sc.nextLong();
			long c = sc.nextLong();
			long d = sc.nextLong();

			if(a < b || d < b) {
				res[i] = "No";
			}else if(c >= b){
				res[i] = "Yes";
			}else {
				long tmp;
				long x = Math.max(b, d);
				long y = Math.min(b, d);
		        while ((tmp = x % y) != 0) {
		            x = y;
		            y = tmp;
		        }
		        if(b + a%y - y <= c) {
		        	res[i] = "Yes";
		        }else {
		        	res[i] = "No";
		        }
			}
		}
		for(int i=0;i<n;i++) {
			System.out.println(res[i]);
		}


	}
}