import java.util.*;
import java.math.*;
public class Euler {
	
	public static void main(String[] args) {
		
	   Scanner in = new Scanner(System.in);
	   
	   int r1 = in.nextInt();
	   int r2 = in.nextInt();
	   int c1 = in.nextInt();
	   int c2 = in.nextInt();
	   int d1 = in.nextInt();
	   int d2 = in.nextInt();
	   
	   boolean bol = false;
	   
	   for (int i =1; i <= 9; i++) {
		   
		   int x = i;
		   
		   int a = r1 - x;
		   int b = c1 - x;
		   int c = 10;
		   c = (d1 - x == r2 - c1 + x) ? d1 - x : 10;
		   
		   if (a <= 9 && a >= 1 && b <= 9 && b >= 1 && c >= 1 && c <= 9 && x != b && a != c && x != a && b != c && x != c && b != a ) {
			   
			   System.out.println(x + " " + a);
		       System.out.println(b + " " + c);
			   bol = true;
			   break;
			   
			   
			   
		   } 
	   }
	   
	   if (!bol) System.out.println("-1");
       
       
        
	}
	
	
	
	
	
}

