import java.io.*;
import java.util.*;
import java.math.*;


public class Solution{  
	
 public static void main(String[] args) { 
     
     Scanner in = new Scanner(System.in);
     
     int n;
     long answer=0;
     
     n=in.nextInt();
     
     if(n<=4){
    	 if(n==1){
    		 answer=1l;
    	 }
    	 if(n==2){
    		 answer=2l;
    	 }
    	 if(n==3){
    		 answer=6l;
    		 
    	 }
    	 if(n==4){
    		 answer=12l;
    	 }
     }
     
     else if(n%2==1){
    	 answer=(long)n*(n-1)*(n-2);
     }
     else if(n%3!=0){
    	 answer=(long)n*(n-1)*(n-3);
     }
     else{
    	 answer=(long)(n-1)*(n-2)*(n-3);
     }
     
     System.out.println(answer);
 }
}
