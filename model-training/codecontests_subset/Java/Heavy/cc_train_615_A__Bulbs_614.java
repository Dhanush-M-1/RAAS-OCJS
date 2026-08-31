import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bulbs {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer res = new StringTokenizer(in.readLine());
	    int n = Integer.parseInt(res.nextToken());
	    int m = Integer.parseInt(res.nextToken());
	    boolean [] on =new  boolean[m];
	    for (int i = 0; i < n; i++) {
	    	StringTokenizer line = new StringTokenizer(in.readLine());
	    	int cant = Integer.parseInt(line.nextToken());
	    	for (int j = 0; j < cant; j++) {
	    		int bulb=Integer.parseInt(line.nextToken());
	    		on[bulb-1]=true;
			}
		}
	    String bool ="YES";
	    while(bool=="YES"){
	    	for (int k = 0; k < on.length; k++) {
		    	  if (!on[k]) bool="NO"; 
		    }
	    	break;
	    }
	    System.out.println(bool);
	}
}