import java.util.Scanner;


public class Main {

	
	public static void main(String[] args) {
		Scanner theScanner = new Scanner(System.in);
		
		int pop = theScanner.nextInt();
		int numWizards = theScanner.nextInt();
		int percentage = theScanner.nextInt();
		
		int clonesRequired = 0;
		while( Math.floor( (100*(numWizards + clonesRequired)/pop)) 
																	< percentage){
		
			clonesRequired++;
		}
		System.out.println(clonesRequired);
	}

}

 	  			 				 		 		   	  	    		