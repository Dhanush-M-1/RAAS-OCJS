
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B {
    
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int [] types = new int[11];
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int maxType = Integer.parseInt(tokenizer.nextToken());
        tokenizer = new StringTokenizer(br.readLine());
        
        
        for(int i=0; i<N; i++) { 
            int elem = Integer.parseInt(tokenizer.nextToken());
            types[elem]++;
        }
        
        int [] sums = new int[maxType + 1];
        
        sums[maxType] = types[maxType]; 
        
        for(int i=maxType - 1; i>=0; i--) 
            sums[i] = types[i] + sums[i + 1];


        int totalCounter = 0;

        for(int i=0; i<maxType; i++) { 
            totalCounter += types[i] * sums[i+1];
        }


        System.out.println(totalCounter);
        
        
        
    }

}
