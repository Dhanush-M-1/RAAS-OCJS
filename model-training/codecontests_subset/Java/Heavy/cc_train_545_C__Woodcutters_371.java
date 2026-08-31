import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;


public class CF_303_D {
    public static void main(String[] args) throws IOException{
        PrintWriter pw = new PrintWriter(System.out, true);
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        String[] line;
        
        int[] X = new int[n];
        int[] H = new int[n];
        for(int i = 0 ; i < n ; i++){
            line = input.readLine().split(" ");
            X[i] = Integer.parseInt(line[0]);
            H[i] = Integer.parseInt(line[1]);
        }
        int l , r, ans = 1;
        l = X[0];
        for(int i = 1 ; i < n  ; i++){
            if(i == n-1){
                ans++;
                break;
            }
            r = X[i+1];
            
            if(X[i] - H[i] > l){
                ans++;
            
                l = X[i];
            }else if(X[i] + H[i] < r){
                ans++;
            
                l = X[i] + H[i];
            }else{
                l = X[i];
            }
            
        }
        
        pw.println(ans);
        
        pw.close();
        input.close();
    }
}
