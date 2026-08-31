//package cf653div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class B {
    public static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            int num = Integer.parseInt(br.readLine());
            int copy = num;
            int pow2 = 0;
            int pow3 = 0;
            while (copy%2==0){
                copy/=2;
                ++pow2;
            }

            while (copy%3==0){
                copy/=3;
                ++pow3;
            }
            if(copy!=1){
                out.println(-1);
                continue;
            }
            int y2 = pow3;
            int y1 = y2 - pow2;
            //out.println(y1+" "+y2+" "+pow2+" "+pow3);
            if (y1<0 || y2<0){
                out.println(-1);
                continue;
            }
            out.println(y1+y2);
        }
        out.close();
    }
}
