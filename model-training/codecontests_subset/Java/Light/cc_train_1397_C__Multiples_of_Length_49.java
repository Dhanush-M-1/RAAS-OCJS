
import java.util.*;
import java.io.*;
public class C {

	public static void main(String[] args) {
		
	Scanner sc=new Scanner(System.in);
	     int n=sc.nextInt();
	     int a[]=new int[n];
	     for(int i=0;i<n;i++) {
	     	a[i]=sc.nextInt();
	     }
	       if(n==1) {
	       	System.out.println("1"+" 1");
	       	System.out.println(-1*a[0]);
	       	System.out.println("1"+" 1");
	       	System.out.println(0);
	       	System.out.println("1"+" 1");
	       	System.out.println(0);
	       }else if(n==2){
	       	System.out.println("1"+" 1");
	       	System.out.println(-1*a[0]);
	       	System.out.println("2"+" 2");
	             	System.out.println(-1*a[1]);
	             	System.out.println("1"+" 1");
	             	System.out.println(0);
	       }else {
	     
	       	System.out.println("1 "+n);
	       	for(int i=0;i<n-1;i++) {
	       		System.out.print(-1*(long)n*a[i]+" ");
	       		
	       	}
	       	System.out.println(0);
	       	System.out.println("1 "+ (n-1));
	       	for(int i=0;i<n-1;i++) {
	       		System.out.print(1*(long)(n-1)*a[i]+" ");
	       		
	       	}
	       	System.out.println();
	       	System.out.println(n+" "+n);
	       	System.out.println(a[n-1]*-1);
	       
	             
	      

	}
	}
	static int[] arr(int n,Scanner sc) {
		int a[]=new int[n];
		for(int i=0;i<n;i++) {
			a[i]=sc.nextInt();
		}
		return a;
}

}
