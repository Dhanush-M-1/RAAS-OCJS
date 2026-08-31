import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String in[] = br.readLine().split(" ");
		int switches = Integer.parseInt(in[0]);
		int bulbs = Integer.parseInt(in[1]);
		boolean start[] = new boolean[bulbs];
		for(int i=0; i<switches; i++) {
			String in2[] = br.readLine().split(" ");
			for(int j=1; j<in2.length; j++) {
				start[Integer.parseInt(in2[j]) - 1] = true;
			}
		}
		boolean success = true;
		for(int i=0; i<bulbs; i++) {
			if(start[i] == false)
				success = false;
		}
		if(success)
			System.out.println("YES");
		else
			System.out.println("NO");
	}

}

    	 	 	    	 	 	  		  				 		