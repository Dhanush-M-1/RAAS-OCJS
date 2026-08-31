import java.io.BufferedReader;
import java.io.InputStreamReader;


public class m2 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String []s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int a = Integer.parseInt(s[1]);
        int b = Integer.parseInt(s[2]);
        int c = Integer.parseInt(s[3]);
        int res = 0;
        for (int i = 0; i <= a; i++) {
            for (int j = 0; j <= b; j++) {
                if(i%2!=0)
                    continue;
                int tot = (int)((i * 0.5) + j);
                int rem = n - tot;
                int r = rem/2;
                if(rem<0 || rem%2!=0 || r > c)
                    continue;
                res++;
            }
        }
        System.out.println(res);
    }
}
