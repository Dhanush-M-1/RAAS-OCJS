import java.io.*;
import java.util.*;

public class cf273A {
    public static void main(String[] args) throws Exception {
    	// BufferedReader in = new BufferedReader(new FileReader("cf273A.in"));
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	
		String[] arr = in.readLine().split(" ");
		
		int c1 = Integer.parseInt(arr[0]);		
		int c2 = Integer.parseInt(arr[1]);		
		int c3 = Integer.parseInt(arr[2]);		
		int c4 = Integer.parseInt(arr[3]);		
		int c5 = Integer.parseInt(arr[4]);
		int sum = c1 + c2 + c3 + c4 + c5;
		if(sum % 5 == 0 && sum != 0) {
			System.out.println(sum / 5);
		} else {
			System.out.println(-1);
		}
	}
}