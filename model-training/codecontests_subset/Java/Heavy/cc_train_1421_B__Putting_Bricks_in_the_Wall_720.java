
import java.util.*;
import java.lang.*;
import java.io.*;

public class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner scan = new Scanner(System.in);
		
		int tc = scan.nextInt();
		
		while(tc>0){
		    tc--;
		  //  System.out.println("1 input");
		    int n = scan.nextInt();
 
		    int startRight = 0;
		    int startBottom = 0;
		    
		    int finishTop = 0 ;
		    int finishLeft = 0;
		    
		    if( n == 3 ){
			    for(int i = 0 ; i< n ; i++){
    		        if(i == 0 ){
    		            startRight = Integer.parseInt(scan.next().charAt(1) +"" );
    		            continue;
    		        }  
    		        if( i ==( n-2)){
    		            String temp =scan.next();
    		            startBottom = Integer.parseInt(temp.charAt(0) +"");
     		            finishTop = Integer.parseInt(temp.charAt(n-1) +"");
    		            continue;
     		        }  if( i ==( n-1)){
    		            finishLeft = Integer.parseInt(scan.next().charAt(n-2) +"");
    		            continue;
    		        }
    		        scan.next();
    		    }
		    }else{
    		    for(int i = 0 ; i< n ; i++){
    		        if(i == 0 ){
    		            startRight = Integer.parseInt(scan.next().charAt(1) +"" );
    		            continue;
    		        }  if( i == 1){
    		            startBottom = Integer.parseInt(scan.next().charAt(0) +"");
    		            continue;
    		        }  if( i ==( n-2)){
    		            String temp =scan.next();
    		          //  System.out.println("Input top " + temp);
    		            finishTop = Integer.parseInt(temp.charAt(n-1) +"");
    		            continue;
    		        }  if( i ==( n-1)){
    		            finishLeft = Integer.parseInt(scan.next().charAt(n-2) +"");
    		            continue;
    		        }
    		        scan.next();
    		    }
		        
		    }

            
		    if(startRight == startBottom && finishLeft == finishTop && startBottom != finishTop ){
		        System.out.println(0);
		    }else if (startRight == startBottom && finishLeft == finishTop && startBottom == finishTop){
		            System.out.println(2);
		            System.out.println("1 2");
		            System.out.println("2 1");
		    }else if (startBottom == startRight && finishTop != finishLeft ){
		        if(finishLeft == startRight){
		            System.out.println(1);
		            System.out.println((n ) +" "+ (n-1));
		        }else if (finishTop == startRight){
		            System.out.println(1);
		            System.out.println((n-1) +" "+ (n ));
		        } 
		    }else if (startBottom != startRight && finishTop == finishLeft ){
		        if(finishLeft == startRight){
		            System.out.println(1);
		            System.out.println("1 2");
		        }else if (finishLeft == startBottom){
		            System.out.println(1);
		            System.out.println("2 1");
	            } 
		    }else if(startRight == finishLeft && startBottom == finishTop && startBottom != startRight&& finishLeft != finishTop ){
		        System.out.println(2);
	            System.out.println("1 2");
	            System.out.println((n-1) +" "+ (n ));
		    }else{
		        System.out.println(2);
	            System.out.println("1 2");
	            System.out.println((n ) +" "+ (n-1));
		    }
		    
		    
		}
	}
}
