import java.io.*;
import java.util.*;

public final class Solution {

    public static void main (String[] args) throws IOException{
    	Scanner s = new Scanner(System.in);
    	
    	int t = s.nextInt();
    	
    	for (int t1=1;t1<=t;t1++) {
    		int a = s.nextInt();
    		int b = s.nextInt();
    		int c = s.nextInt();
    		
    		if (c<a) {
    			System.out.println(c);
    		}else {
    			if (b%c==0) {
    				System.out.println(b+c);
    			}else {
    				System.out.println(((b/c)*c)+c);
    			}
    			continue;
    		}
    	}
    }
    
}
