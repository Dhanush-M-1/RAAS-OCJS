import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class A_Div2_226 {
    public static void main(String[]arg) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n,i,c;
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int[]x = new int[n];
        st = new StringTokenizer(in.readLine());
        for(i = 0; i < n; i++)
        {
            x[i] = Integer.parseInt(st.nextToken());
        }
        int max = 0;
        
        
            for(i = 1; i < n; i++)
            {
                max = Math.max(x[i-1] - x[i] - c, max);
            }
            System.out.println(max);
        
    }
}
