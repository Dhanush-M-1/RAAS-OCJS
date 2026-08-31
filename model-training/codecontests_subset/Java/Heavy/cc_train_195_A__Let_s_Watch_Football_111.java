import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.Vector;


public class Solve {
	public static void main(String[] args) throws IOException{
		FastScanner sc = new FastScanner();
	    PrintWriter out = new PrintWriter(System.out);
	    double A =sc.nextInt();
	    double B =sc.nextInt();
	    double C=sc.nextInt();
	    double x =  ((A - B) * C + B - 1) / B ;
	    System.out.println((int)(x));
	  
	   
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    }
	    
	    

	    
	    
	
	   
	    	
	    	
	    }
	
	 
	    
	    

  

	  
	   
	    	
	    	
	 
	    
	    
	    		
	  	
	    	
	    	
	 
	    

	




	
	
	
	
	
	
	






























class FastScanner {




    BufferedReader br;
    StringTokenizer st;

    public FastScanner() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public FastScanner(String s) {
        try {
            br = new BufferedReader(new FileReader(s));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    String nextToken() {
        while (st == null || !st.hasMoreElements()) {
            try {
            	
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(nextToken());
    }

    long nextLong() {
        return Long.parseLong(nextToken());
    }

    double nextDouble() {
        return Double.parseDouble(nextToken());
    }
 
  
	}
