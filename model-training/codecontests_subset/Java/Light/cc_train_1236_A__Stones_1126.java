import java.util.*;
import java.io.*;

public class A1236 {
	public static void main(String[] args) throws IOException {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st;
		
		
		int t = sc.nextInt();
		while(t-->0) {
			int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
			int x = b * 2;
			if(x == c)
				System.out.println(b + c);
			else if(x < c) {
				System.out.println(b + x);
			} else {
				int sum = c - c%2 + (c / 2);
				b -= c / 2;
				if(a * 2 == b) {
					sum += a + b;
				} else if(a * 2 < b) {
					sum += a + a * 2;
				} else {
					sum += b - b%2 + (b / 2);
				}
				System.out.println(sum);
			}
		}
	}
}
