import java.util.*;
public class Main {
    static int n;
    static int[] arr;
	public static void main (String[] args){
	    Scanner sc = new Scanner(System.in);
	    n = sc.nextInt();
	    arr = new int[n];
	    for(int i = 0; i < n; ++i) arr[i] = sc.nextInt();
	    
	    //find x
	    double l = -(1e9 + 3), r = 1e9 + 3;
	    for(int i = 0; i < 200; ++i){
	        double g1 = (l * 2 + r) / 3;
	        double g2 = (l + r * 2) / 3;
	        
	        if(go(g1) > go(g2)) l = g1;
	        else r = g2;
	    }
	    
	    System.out.printf("%.8f%n", go(l));
	}
	static double go(double in){
	    double[] seq = new double[n];
	    for(int i = 0; i < n; ++i) seq[i] = arr[i] - in;
	    
	    double curr = 0, out = 0, min = 0, max = 0;
	    for(int i = 0; i < n; ++i){
	        curr += seq[i];
	        double temp1 = Math.abs(curr - min);
	        out = Math.max(out, temp1);
	        double temp2 = Math.abs(curr - max);
	        out = Math.max(out, temp2);
	        
	        min = Math.min(min, curr);
	        max = Math.max(curr, max);
	    }
	    
	    return out;
	}
}