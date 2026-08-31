//package EdRound85_Div2;
import java.io.*;
import java.util.*;

public class A {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());

        for(int z = 0; z<t; z++){
            int n = Integer.parseInt(in.readLine());

            int a = 0;
            int b = 0;
            boolean finished = false;

            for(int i = 0; i<n; i++){
                StringTokenizer st = new StringTokenizer(in.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                if(finished) continue;
                if(x<a || y<b){ //Anything decreased
                    System.out.println("NO");
                    finished = true;
                    continue;
                }
                if(Math.abs(a-x) < Math.abs(b-y)){ //num of clears increased, num of plays didn't
                    System.out.println("NO");
                    finished = true;
                    continue;
                }

                a = x;
                b = y;

            }
            if(!finished) System.out.println("YES");
        }
    }

}
