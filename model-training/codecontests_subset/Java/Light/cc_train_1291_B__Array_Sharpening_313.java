
import java.io.*;
import java.util.*;

public class test5 {
	public static final int mod=1000000007;
	public static void main(String[] args) throws IOException{
		BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
		//Scanner sc=new Scanner(System.in);
		PrintWriter out=new PrintWriter(System.out);
		
		int t=Integer.parseInt(sc.readLine());
		while(t-->0) {
			int n=Integer.parseInt(sc.readLine());
			String[] ip=sc.readLine().split(" ");
			int []arr=new int[n];
			for(int i=0;i<n;i++) {
				arr[i]=Integer.parseInt(ip[i]);
			}
			int p=0,s=n-1;
			while(p<n) {
				if(arr[p]>=p) p++;
				else {p--;break;}
			}
			while(s>=0) {
				if(arr[s]>=n-1-s) s--;
				else {s++;break;}
			}
			if(p<s) {
				out.println("No");
			} else {
				out.println("Yes");
			}
			
			out.flush();		
		}
		
		out.close();		
	}
}

