import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A {
    
    public static void main(String [] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        
        
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());
        
        boolean [] bulbs = new boolean[M];
        
        for(int i=0; i<N; i++) { 
            tokenizer = new StringTokenizer(br.readLine());
            
            int x = Integer.parseInt(tokenizer.nextToken());
            
            for(int j=0; j<x; j++) { 
                int bulb = Integer.parseInt(tokenizer.nextToken()) -1;
                bulbs[bulb] = true;
            }
        }
        
        boolean isGood = true;
        
        for(int i=0; i<M; i++) { 
            if(!bulbs[i]) { 
                isGood = false;
                break;
            }
        }
        
        
        if(isGood) System.out.println("YES");
        else System.out.println("NO");
        
        
    }

}