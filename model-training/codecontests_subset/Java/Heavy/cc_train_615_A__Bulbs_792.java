
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws IOException {
    	
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    	StringTokenizer H = new StringTokenizer(in.readLine());
    	int n = Integer.parseInt(H.nextToken());
    	int bulbs = Integer.parseInt(H.nextToken());
    	
    	boolean [] b = new boolean [bulbs];
    	
    	for(int i=0;i<n;i++) { 
    		
    		H = new StringTokenizer(in.readLine());
    		H.nextToken();
    		while(H.hasMoreTokens()) {
    			
    		b[Integer.parseInt(H.nextToken())-1] = true;
    		}
    	}
    	
    	
    	boolean answer = true;
    	for(int i=0;i<bulbs;i++) {
    		if(b[i] == false) answer = false;
    	}
    	
    	
    	if(answer) System.out.println("YES");
    	else System.out.println("NO");
    	}
    		
    }

