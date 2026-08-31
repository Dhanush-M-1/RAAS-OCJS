import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
	public static void main (String[] args) throws java.lang.Exception {
	    Scanner in = new Scanner(System.in);
	    int m = in.nextInt();
	    
	    for (int i = 0; i<m; i++){
	        int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		if (c%3==2){
		    System.out.println(a ^ b);
		} else if (c%3==0){
		    System.out.println(a);
		}else{
		    System.out.println(b);
		}
	    }
		
		
	}
}