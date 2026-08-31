//package fun;
import java.io.*;
import java.util.*;
import static java.lang.System.out;

public class Fun {
    public static void main(String[] args) throws IOException{        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] c = new int[N][2];
        for(int i=0;i<N;++i){
            String[] s = br.readLine().split("\\s");
            c[i][0] = Integer.parseInt(s[0]);
            c[i][1] = Integer.parseInt(s[1]);
        }
        out.println(judge(c));
    }  
    
    private static int judge(int[][] coords){
        int cnt = 0;
        int prev_point = coords[0][0] - coords[0][1];
        for(int i=1;i<coords.length-1;++i){
            int curr_point = coords[i][0];
            int h = coords[i][1];            
            int next_point = coords[i+1][0];
            
            if(prev_point < (curr_point - h) && coords[i-1][0] < (curr_point - h)){
                cnt++;
                prev_point = curr_point - h;
            }else if(curr_point + h < next_point){
                cnt++;
                prev_point = curr_point + h;
            }        
        }
        
        if(coords.length > 1) return cnt + 2;        
        return 1;
    }
}