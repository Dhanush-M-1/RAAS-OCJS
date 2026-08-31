import java.util.*;
import java.lang.Math;
public class CA{

public static void main(String [] args){
	Scanner obj=new Scanner (System.in);
	    int q=obj.nextInt();
	     int req=0;
	    while(q-->0)
	    {   req=0;
	    	int a=obj.nextInt();
	    	int b=obj.nextInt();
	    	int c=obj.nextInt();
	    	int k1=a;
            int k2=b;
            int k3=c;
	    	int req1=0;
	    	 {
	    	 	while(b>0&&c>=2){
	        	b=b-1;
	            c=c-2;
	            req=req+3;
	        }
	        while(a>0&&b>=2){
	        	a=a-1;
	        	b=b-2;
	        	req=req+3;
	    	 }
                 }
	        while(k1>0&&k2>=2){
	        	k1=k1-1;
	        	k2=k2-2;
	        	req1=req1+3;

	        }
	        while(k2>0&&k3>=2){
	        	k2=k2-1;
	            k3=k3-2;
	            req1=req1+3;

	    	}
	    	System.out.println(Math.max(req,req1));
	    }
           }

	    }
	  
    
