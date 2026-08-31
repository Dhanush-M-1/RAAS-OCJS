import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;

public class Codeforces {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n  = Integer.parseInt(br.readLine());
	    String str = br.readLine();
	    int max = Integer.MIN_VALUE;
	    String ans = "";
	    for(int i=0;i<n-1;i++) {
	    	int count=1;
	    	for(int j=i+1;j<n-1;j++) {
		    	if(str.charAt(i)==str.charAt(j)&&str.charAt(i+1)==str.charAt(j+1)) {
		    		count++;
		    	}
		    	
	    	}
	    	if(count>max) {
	    		String s = "";
	    		s=s.concat(String.valueOf(str.charAt(i)));
		    	s=s.concat(String.valueOf(str.charAt(i+1)));
		    	ans = s;
		    	max = count;
	    	}
	    }
	    System.out.println(ans);
	    
	        
	}
}