import java.util.*;
import java.io.*;
import java.lang.*;

public class cfs {

	public static void main(String[] args)  {
      
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0) {
			int n=sc.nextInt();
			int m=sc.nextInt();
	   sc.nextLine();
	   char c[]=sc.nextLine().toCharArray();
	  
	   int p[]=new int[m];
	   for(int i=0;i<m;i++) {
		   p[i]=sc.nextInt();
	   }
	   Arrays.sort(p);
	   
	   int mi[]=new int[n+1];
	  // Arrays.fill(mi,1);
	   for(int i=m-1;i>=0;i--) {
		   mi[p[i]]=m-i+1;   
	   }
	 
	   
	   if(p[m-1]<n)for(int j=p[m-1]+1;j<=n;j++)mi[j]=1;
	    int st=mi[n];
	   for(int i=n;i>=0;i--) {
		   if(mi[i]!=0) {
			   st=mi[i];
		   }else {
			   mi[i]=st;
		   }
	   }
	   
	   
	 /*  for(int i=0;i<=n;i++) {
		   System.out.print(mi[i]+" ");
	   }
	   System.out.println();
	   */
	   int ch[]=new int[26];
	   for(int i=0;i<n;i++) {
		   int cc=c[i]-'a';
		   int v=mi[i+1];
		   ch[cc]+=v;
	   }
	   for(int i=0;i<26;i++) {
		   System.out.print(ch[i]+" ");
	   }
	   System.out.println();
	   

}

}

}