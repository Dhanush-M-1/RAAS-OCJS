

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        bw.append(solve(Integer.parseInt(br.readLine()))+"\n");
        bw.close();
        
    }

    private static long solve(int x) {
        if(x==1) return 1;
        if(x==2) return 2;
        if(x==3) return 6;
        if(x%2==1) return 1l*x*(x-1)*(x-2);
        else{
            if(x%3==0) {
                return 1l*(x-1)*(x-2)*(x-3);
            }
            return 1l*x*(x-1)*(x-3);
        }

    }

    
    
}
