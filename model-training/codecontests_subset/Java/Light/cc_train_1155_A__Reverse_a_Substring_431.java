
import java.util.*;
import java.lang.*;
import java.io.*;

public final class Main {
    static int[] memo;
	public static void main (String[] args) throws java.lang.Exception {
	    Scanner in=new Scanner(System.in);
	        int n=in.nextInt();
	        int a,b,max=0;
	        int start=0,end;
	       
	       String s=in.next();
	        max=(int) s.charAt(0);
	       for(int i=1;i<n;i++){
	          
	            b=(int)s.charAt(i);
	           if(b>max){
	           max=b;
	           start=i;
	           }
	           
	           
	            if(max>b){
	                System.out.println("YES");
	                i++;
	                start++;
	                System.out.println(start+" "+i);
	                return;
	                
	           }
	       }
	       
	   System.out.println("NO");
	}

}