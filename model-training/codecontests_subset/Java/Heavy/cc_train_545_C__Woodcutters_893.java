import java.io.*;
import java.util.*;
public class temp{
    public static void main(String[] arg) throws Exception
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[] x = new int[n];
        int[] h = new int[n];
        for (int i = 0; i < n; i++)
        {
            String[] tokens = in.readLine().split(" ");
            x[i] = Integer.parseInt(tokens[0]);
            h[i] = Integer.parseInt(tokens[1]);
        }
        int ret;
        if (n > 1)
            ret = 2;
        else ret = 1;
        boolean right = false;
        for (int i = 1; i < n-1; i++)
        {
            if (!right)
            {
                if (x[i] - h[i] > x[i-1])
                    ret++;
                else if (x[i] + h[i] < x[i+1])
                {
                    right = true;
                    ret++;
                }
            }
            else
            {
                if (x[i] - h[i] > x[i-1] + h[i-1])
                {
                    ret++;
                    right = false;
                }
                else if (x[i] + h[i] < x[i+1])
                {
                    ret++;
                    right = true;
                }
                else
                {
                    right = false;
                }
            }
        }
        System.out.print(ret);
    }
}