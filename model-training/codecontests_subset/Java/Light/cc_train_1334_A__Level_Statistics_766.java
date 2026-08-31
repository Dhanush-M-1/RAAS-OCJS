import java.util.*;
import java.io.*;
import java.lang.*;

public class cfrcs {

	static int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}
	  

	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		
	 int t=sc.nextInt();
	 while(t-->0) {
		 int n=sc.nextInt();
		 int p[]=new  int[n];
		 int c[]=new int[n];
		 for(int i=0;i<n;i++) {
			 p[i]=sc.nextInt();
			 c[i]=sc.nextInt();
		 }
		 int flag=0;
		 if(c[0]>p[0]) {
			 flag=1;
		 }
		 for(int i=1;i<n;i++) {
			 if(p[i]<p[i-1]||c[i]>p[i]||c[i]-c[i-1]>p[i]-p[i-1]) {
				 flag=1;break;
			 }if(c[i]<c[i-1]) {
				 flag=1;
				 break;
			 }
			 if(p[i]==p[i-1]&&c[i]!=c[i-1]) {
				 flag=1;
				 break;
			 }
		 }
		 
		 
		   if(flag==1)System.out.println("NO");
		   else System.out.println("YES");
	 }
	
	   
	   

}
}