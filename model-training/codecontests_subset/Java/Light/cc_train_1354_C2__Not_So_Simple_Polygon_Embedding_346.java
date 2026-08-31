import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution {
    
	public static void main (String[] args) {
	    Scanner scan = new Scanner(System.in);
	    
	    int T = scan.nextInt();
	    while(T-- > 0) {
	        int n = scan.nextInt();
	        n *= 2;
	        
	        double angleUp = 180 * (double)(n - 1) / (double)(2 * n);
	        angleUp = Math.toRadians(angleUp);
	        double angleDown = 180 / (double)n;
	        angleDown = Math.toRadians(angleDown);
	        
	        double side = Math.sin(angleUp) / Math.sin(angleDown);
	        System.out.println(side);
	    }
	}
}
