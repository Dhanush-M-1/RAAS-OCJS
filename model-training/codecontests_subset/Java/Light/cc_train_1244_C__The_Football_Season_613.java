import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long n = Long.parseLong(st.nextToken());
		long p = Long.parseLong(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		long z;
		int g = gcd(w , d);
		long x;
		if(p % g != 0) {
			System.out.println(-1);
			System.exit(0);
		}
		long l = w/g;
		
		for(long y = 0; y < l; y++) {
			if((p - y*d) % w== 0) {
				x = (p - y*d) / w;
				z = n - (x + y);
				if(z >= 0 && x >= 0) {
					System.out.println(x + " " + y + " " + z);
					System.exit(0);
				}else {
					System.out.println(-1);
					System.exit(0);
				}
			}
		}
		System.out.println(-1);
		
	}
	static int gcd(int x , int y) {
		// x > y
		if(y == 0) {
			return x;
		}else {
			return gcd(y , x % y);
		}
	}
}