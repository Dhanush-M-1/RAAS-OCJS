import java.io.*;
import java.util.*;

public class revive {
    
    public static int calculate_coins(int a, int b){
        int x = Math.min(a, b/2);
        if(x<=0){
            return 0;
        }
        return 3*(x);
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        int res = 0;
        while(t-->0){
            String[] input = in.readLine().trim().split("\\s+");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);
            int drive_1 = Math.min(a, b/2)==0?0:Math.min(a, b/2);
            int drive_2 = Math.min(b, c/2)==0?0:Math.min(b, c/2);
            res = Math.max(calculate_coins(b, c) + calculate_coins(a, b-drive_2), calculate_coins(a, b) + calculate_coins(b-2*drive_1, c));
            System.out.println(res);
        }
    }
}

