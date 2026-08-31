import java.util.*;
import java.io.*;


public class A1208{
	public static void main(String args[])throws IOException{
		Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		PrintWriter pw=new PrintWriter(System.out);
		int t=sc.nextInt();
		while(t--!=0){
			long a=sc.nextLong();			long b=sc.nextLong();		
			long n=sc.nextLong();
			if(n%3==0)
				pw.println(a);
			else if(n%3==1)
				pw.println(b);
			else
				pw.println(a^b);
		}
		pw.close();
	}
}