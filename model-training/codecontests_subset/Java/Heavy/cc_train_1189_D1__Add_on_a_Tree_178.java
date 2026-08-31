import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Controller {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        int n = Integer.parseInt(reader.readLine());
        int[] step = new int[n];
        for(int  i = 0; i < n-1; ++i){
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            step[x] ++;
            step[y]++;
        }
        for(int i = 0; i < n; ++i){
            if(step[i] == 2){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
