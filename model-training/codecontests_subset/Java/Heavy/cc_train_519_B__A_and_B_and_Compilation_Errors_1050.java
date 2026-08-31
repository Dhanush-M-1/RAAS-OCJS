import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    Scanner sc=new Scanner(System.in);
	    int n=sc.nextInt();
	    int a[]=new int [n];
	    int b[]=new int[n-1];
	    int c[]=new int [n-2];
	    for(int i=0;i<n;i++){
	        a[i]=sc.nextInt();
	    }
	    for(int i=0;i<n-1;i++){
	        b[i]=sc.nextInt();
	    }
	    for(int i=0;i<n-2;i++){
	        c[i]=sc.nextInt();
	    }
	    Arrays.sort(a);
	    Arrays.sort(b);
	    Arrays.sort(c);
	    
	    boolean f=true;
	    for(int i=0;i<n-1;i++){
	        if(b[i]!=a[i]){
	            System.out.println(a[i]);
	            f=false;
	            break;
	        }
	    }
	    if(f){
	        System.out.println(a[n-1]);
	    }
	    
	    f=true;
	    for(int i=0;i<n-2;i++){
	        if(c[i]!=b[i]){
	            System.out.println(b[i]);
	            f=false;
	            break;
	        }
	    }
	    if(f){
	        System.out.println(b[n-2]);
	    }
	}
}