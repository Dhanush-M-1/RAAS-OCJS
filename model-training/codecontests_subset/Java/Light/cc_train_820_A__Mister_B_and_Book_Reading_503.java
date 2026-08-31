//package MisterB;

import java.io.*;
import java.util.*;

public class MisterB {
    public static void main (String [] args) throws IOException {

    BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(fin.readLine());
    
    int c = Integer.parseInt(st.nextToken());
    int v0 = Integer.parseInt(st.nextToken());
    int v1 = Integer.parseInt(st.nextToken());
    int a = Integer.parseInt(st.nextToken());
    int l = Integer.parseInt(st.nextToken());
    int count = 0;
    
    if(c - v0 == 0) {
    	System.out.println(1);
    }
    
    else {
	    while(c > 0) {
	    	if(v0 > v1) {
	        	c -= v1;
	        	if(c <= 0) {
	        		count++;
	        		break;
	        	}
	        	c += l;
	        	count++;
	    	}

	    	else {
	        	c -= v0;
	        	if(c <= 0) {
	        		count++;
	        		break;
	        	}
	        	v0 += a;
	        	c += l;
	        	count++;
	    	}
	    }
    	System.out.println(count);
    }
    
    }
}