



import java.util.*;
import java.io.*;
import java.lang.*;
  
public class test {

     public static void main(String args[]) { 
		  
                  try{
		  Scanner sc= new Scanner(System.in);
		  
		  int t = sc.nextInt();
		  
		  while(t-->0) { 
			  
			 int n = sc.nextInt();
			 
			 long a[] = new long[n];
			 
			 for(int i=0;i<n;i++) { 
				 a[i] = sc.nextLong();
			 }
			 
			 if(a[0] + a[1] <= a[n-1]) { 
				 System.out.println(1+" "+2+" "+n);
			 }
			 else { 
				 System.out.println(-1);
			 }
			}
			 
		  }
                 catch( Exception e){ return;}
	      
	  }
	}
	 
	
