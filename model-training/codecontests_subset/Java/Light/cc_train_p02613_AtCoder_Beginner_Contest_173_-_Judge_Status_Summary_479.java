
import java.util.*;
import java.math.*;
public class Main {
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int c0 =0, c1=0 , c2=0 ,c3 = 0;
		
		for (int i = 0; i < N; i++) {
            String d = sc.next();
			if (d.equals("AC")){c0++;}
			if (d.equals("WA")){c1++;}
			if (d.equals("TLE")){c2++;}
			if (d.equals("RE")){c3++;}
		}
		
		

      System.out.println("AC "+"x "+ c0 );
	  System.out.println("WA "+"x "+ c1 );
	  System.out.println("TLE "+"x "+ c2 );
	  System.out.println("RE "+"x "+ c3 );
      
    }
}