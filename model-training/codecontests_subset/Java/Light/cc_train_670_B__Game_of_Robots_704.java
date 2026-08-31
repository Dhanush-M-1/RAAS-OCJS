import java.util.Scanner;
import java.util.ArrayList;
	
	import java.io.*;
	public class mohamedy23 {
	  public static void main(String[]arg) {
		  Scanner sc=new Scanner(System.in);
		 int n=sc.nextInt();
         int k =sc.nextInt();
         int a[]=new int[n];
         for(int i = 0 ;i<n;i++) {
        	 a[i]=sc.nextInt();
         }
        int i=1;
        while(k>i) {
        	k-=i;
        	i++;
        }
        System.out.print(a[--k]);
		 }
		
	  
}
  
