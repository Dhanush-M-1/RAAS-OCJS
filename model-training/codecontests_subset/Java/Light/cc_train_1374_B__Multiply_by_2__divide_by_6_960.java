import java.util.*;
import java.io.*;

public class B{
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main (String[] args) throws java.lang.Exception{
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0){
			int n = Integer.parseInt(br.readLine());
			if(n==1){
				bw.write("0");
				bw.newLine();
				continue;
			}
		    if(n==3){
				bw.write("2");
				bw.newLine();
				continue;
			}
			if(n==6){
				bw.write("1");
				bw.newLine();
				continue;
			}
			if(n<6){
				bw.write("-1");
				bw.newLine();
				continue;
			}
			int c3 = 0, c2 = 0;
			while(n%3==0){
				c3++;
				n /= 3;
			}
			while(n%2==0){
				c2++;
				n /= 2;
			}
			if(n!=1 || c2>c3){
				bw.write("-1");
				bw.newLine();
			}else{
				int ans = c3 - c2;
				ans += c3;
				bw.write(ans + "");
				bw.newLine();
			}
		}
		bw.flush();
	}
}
