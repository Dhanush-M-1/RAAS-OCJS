import java.util.*;
import java.io.*;

public class Compilation {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()),m = n-1,o=n-2;
		int sum =0, sum1=0,sum2=0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		while(n-->0) {
			sum+=Integer.parseInt(st.nextToken());
			
		}
		
		st = new StringTokenizer(br.readLine());
		
		while(m-->0) {
			sum1+=Integer.parseInt(st.nextToken());
			
		}
		System.out.println(sum-sum1);
		
		st = new StringTokenizer(br.readLine());
		
		while(o-->0) {
			sum2+=Integer.parseInt(st.nextToken());
			
		}
		
		System.out.println(sum1-sum2);
	}
}
