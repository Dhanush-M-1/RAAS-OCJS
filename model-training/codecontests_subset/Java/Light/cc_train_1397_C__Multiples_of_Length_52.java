import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException //use buffered reader?
    {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;
        int n = Integer.parseInt(inp.readLine());
        long[] arr = new long[n];
        tk = new StringTokenizer(inp.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Long.parseLong(tk.nextToken());

        System.out.println("1 " +  n);
        for(int i = 0; i < n; i++)
            System.out.print(-arr[i]*n + " ");
        System.out.println();

        if(n==1)
            System.out.println("1 1\n0");
        else
        {
            System.out.println("1 " + (n-1));
            for(int i = 0; i < n-1; i++)
                System.out.print(arr[i]*(n-1) +" ");
            System.out.println();
        }



        System.out.println(n + " " + n);
        System.out.println(-arr[n-1]+arr[n-1]*n);
    }

}
