import java.io.*;
import java.util.StringTokenizer;
//752
public class Solution{
    public static void main(String[] args)  throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        System.out.println(solve(n,x,y));
        input.close();
    }

    static int solve(int n, int x, int y){
        int ans = ((int)Math.ceil(((n*y)/(100.0))))-x; 
        if(ans <= 0){
            return 0;
        }
        return ans;   
    }
}

