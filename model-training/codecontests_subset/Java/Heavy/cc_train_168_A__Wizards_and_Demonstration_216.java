// java Main < input.txt < myoutput.txt

import java.util.*;

public class Main {

    // Shortened functions for printing
    public static void p (Object o) {System.out.print(o);} 
    public static void pn (Object o) {System.out.println(o);}
    
    public static void main(String[] args)  throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int x = scan.nextInt();
        int y = scan.nextInt();
        
        double pct = (double) y / 100;
        
        int answer = (int) (Math.ceil((double) n*pct) - x );
        
        System.out.println(Math.max(answer,0));
    }
}
  	   	 			   		 	 	 			 	  	 	