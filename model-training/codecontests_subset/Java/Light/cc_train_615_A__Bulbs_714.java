import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Solution {
	  
   public static void main(String[] args) {
	   Scanner sc = new Scanner(System.in);
	   int n = sc.nextInt();
	   int m = sc.nextInt();
	   Set<Integer> set = new HashSet<>();
	   for ( int i = 0; i < n; i++) {
		   int k = sc.nextInt();
		   for ( int j = 0; j < k; j++) {
			   set.add(sc.nextInt());
		   }
	   }
	   
	   if ( set.size() == m ) {
		   System.out.println("YES");
	   } else {
		   System.out.println("NO");
	   }
   }
}
