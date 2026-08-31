import java.util.*;
public class Main {
	final static int maxn=(int)2e5+10;
	static int a[]=new int [maxn];
 public static void main(String args[])
 {
	 Scanner input=new Scanner(System.in);
	 int n,k;
	 n=input.nextInt();k=input.nextInt();
	 for(int i=1;i<=n;i++)
		 a[i]=input.nextInt();
	 Arrays.sort(a,1,1+n);
	 if(a[(n+1)/2]==k)System.out.println(0);
	
	 else
	 {
		 long sum=0;
		 if(a[(n+1)/2]<k)
		 {
			 sum+=(long)k-a[(n+1)/2];
			 a[(n+1)/2]=k;
			 for(int i=(n+1)/2+1;i<=n;i++)
			 {
				 if(a[i]<a[i-1])
				 {
					 sum+=(long)a[i-1]-a[i];
					 a[i]=a[i-1];
				 }
			 }
		 }
		 else if(a[(n+1)/2]>k)
		 {
			 //System.out.println(a[(n+1)/2]);
			 sum+=(long)a[(n+1)/2]-k;
			 a[(n+1)/2]=k;
			 for(int i=(n+1)/2-1;i>=1;i--)
			 {
				 if(a[i]>a[i+1])
				 {
					 sum+=(long)a[i]-a[i+1];
					 a[i]=a[i+1];
				 }
			 }
		 }
		 System.out.println(sum);
	 }
 }
}

   	 		     	 	 	 	 	 			  			