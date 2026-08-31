// Oct 17, question A
// java Main < input.txt < myoutput.txt

import java.util.*;

public class Main {

    public static void pn (Object o) {System.out.println(o);}
    
    public static void main(String[] args)  throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int x = scan.nextInt();
        int y = scan.nextInt();
        
        int A = y*n;
        int r = A % 100;
        A = A / 100;
        if (r > 0) {
            A++;
        }
        A -= x;
        
        if (A < 0) {
            pn("0");
        }
        else {
            pn(A);
        }
    }
}

	 	 	 	 		 	     	     		  		