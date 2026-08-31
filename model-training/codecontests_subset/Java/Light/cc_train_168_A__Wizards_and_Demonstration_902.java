import java.util.*;
public class Main {

	public static void main(String[] args) {
         Scanner scan = new Scanner(System.in);
         while(scan.hasNext()){
        	 double n =scan.nextDouble();
        	 double x = scan.nextDouble();
        	 double y = scan.nextDouble();
        	 double num = n*(y/100)-x;
        	 if(num<=0) System.out.println(0);
        	 else{
        		 
        		 if(num == (int)num) System.out.println((int)num);
        		 else System.out.println ((int)num+1);
        	 }
        	 
         }
	}

}

 		  	 	  	     		  		   					