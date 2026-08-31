import java.util.Scanner ;
import java.math.*;
import java.util.*;
public class Hi {
	public static void main(String[] args){
	 Scanner input = new Scanner(System.in);
	 int n = input.nextInt();
	 double sum = 0 ; int max = 0 ; 
	 for(int i= 0 ; i<n ; i++){
		 int u = input.nextInt();
		 if(u>max)max = u ;
		 sum+=u;
		 
	 }
	double ans = (sum)/(n-1) ; 
	ans = Math.ceil(ans);
	System.out.print((int)Math.max(ans, max));
	
	
	
	
	}
	
	
	

	
	    }
	    
	    
	    

		
		
		
							
	



	

		
	
		
	


			
		
		
			

		
		


