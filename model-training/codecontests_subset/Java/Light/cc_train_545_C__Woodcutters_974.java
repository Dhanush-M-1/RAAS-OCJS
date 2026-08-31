import java.io.*;
import java.util.*;
import java.util.TreeSet;
import java.lang.*;
import java.text.DecimalFormat;
public class ab{
	public static void main(String args[]){
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		long count=2;
		int i;
		long []x=new long[n];
		long []h=new long[n];
		for(i=0;i<n;i++){
			x[i]=in.nextLong();
			h[i]=in.nextLong();
		}
		for(i=1;i<n-1;i++){
			long h1=x[i]-h[i];
			long h2=x[i]+h[i];
			if(x[i-1]<h1)
				count++;
			else if(x[i+1]>h2){
				x[i]=h2;
				count++;
			}
		}
		if(n==1)
			count=1;
		System.out.println(count);
			
	}
}