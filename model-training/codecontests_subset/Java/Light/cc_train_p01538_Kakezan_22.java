import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;
 
 
public class Main{
     
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	
    	final int Q = sc.nextInt();
    	
    	for(int i = 0; i < Q; i++){
    		int N = sc.nextInt();
    		int count = 0;
    		
    		while(N >= 10){
    			
    			int len = ((int) Math.log10(N) + 1);
    			
    			int max = -1;
    			
    			for(int j = 1; j < len; j++){
    				int div = (int) Math.pow(10, j);
    				
    				max = Math.max(max, (N / div) * (N % div));
    			}
    			
    			N = max;
    			
    			count++;
    		}
    		
    		System.out.println(count);
    	}
        
    }
     
}