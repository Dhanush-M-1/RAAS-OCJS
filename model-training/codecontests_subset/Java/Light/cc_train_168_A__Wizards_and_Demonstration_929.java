import java.io.*;
import java.util.*;


public class Main
{
	public static void main (String args[]) throws Exception{
		
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		int x = cin.nextInt();
		int y = cin.nextInt();
 		
 		if ((int)(Math.ceil(n * 1.0 * y / 100)) <= x) {
 			System.out.println(0);
 		}else {
 			int result = (int)Math.ceil(n * y * 1.0  / 100 - x);
 			System.out.println(result);
 		}
	}
}
			  	  			 		   			   	 		 			