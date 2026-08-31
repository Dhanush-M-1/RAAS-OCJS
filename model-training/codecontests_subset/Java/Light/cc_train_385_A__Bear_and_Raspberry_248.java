import java.io.*;
import java.util.*;

public class Smile {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);	
		int n = in.nextInt();
		int c = in.nextInt();
		int k1 = in.nextInt();
		int k2;
		int ans = 0;
		for (int i = 1; i < n; i++) {
			k2 = in.nextInt();
			ans = Math.max(k1 - k2 - c, ans);
			k1 = k2;
		} 
		out.println(ans);
		
		out.close();
	}		
}