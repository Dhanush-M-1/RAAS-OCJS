import java.util.*;
import java.io.*;


public class A1043{
	public static void main(String args[])throws IOException{
		Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		PrintWriter pw=new PrintWriter(System.out);
		int n=sc.nextInt();
		int sum=0;
		int max=Integer.MIN_VALUE;
		for(int i=0;i<n;i++){
			int a=sc.nextInt();
			sum+=a;
			max=Math.max(max,a);
		}
		pw.println(Math.max((int)Math.floor(2*sum/n)+1,max));
	pw.close();
	}
}