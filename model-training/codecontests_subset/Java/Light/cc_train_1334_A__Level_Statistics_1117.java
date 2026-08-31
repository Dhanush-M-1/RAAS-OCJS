import java.io.*;
import java.util.*;
 
public class A{
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer st = new StringTokenizer(br.readLine());
		PrintWriter pw = new PrintWriter(System.out);
		int t = Integer.parseInt(st.nextToken());
		for(int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int p = 0;
			int c = 0;
			boolean yesorno = true;
			for(int r = 0; r < n; r++) {
				st = new StringTokenizer(br.readLine());
				int tp = Integer.parseInt(st.nextToken());
				int tc = Integer.parseInt(st.nextToken());
				if(tp >= p && tc >= c && tp-p >= tc-c) {
					p = tp;
					c = tc;
				}else {
					yesorno = false;	
					p = tp;
					c = tc;
				}
			}
			if(yesorno) {
				pw.println("YES");
			}else {
				pw.println("NO");
			}
		}
		
		pw.flush();
	}
}