
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.Math.max;

public class B_Run_For_Your_Prize {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;
        int n = parseInt(in.readLine());
        int max1 = 0, max2 = 0;
        tk = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) {
            int num = parseInt(tk.nextToken());
            if(num <= 500000) max1 = num;
            else {max2 = num;break;}
        }
        int ans = 0;
        if(max1 == 0) ans = (int)1e6 - max2;
        else if(max2 == 0) ans = max1 - 1;
        else ans = (int) max(max1 - 1,1e6 - max2);
        System.out.println(ans);
    }
}
