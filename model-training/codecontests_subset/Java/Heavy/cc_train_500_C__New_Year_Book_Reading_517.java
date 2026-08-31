import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.Math.abs;
import java.util.*;
import java.io.*;
import java.math.*;

public class x500C
{
    public static void main(String hi[]) throws Exception
    {
        BufferedReader infile = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(infile.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = readArr(N, infile, st);
        int[] books = readArr(M, infile, st);
        for(int i=0; i < M; i++)
            books[i]--;
        ArrayList<Integer> order = new ArrayList<Integer>();
        boolean[] seen = new boolean[N];
        for(int b: books)
            if(!seen[b])
            {
                order.add(b);
                seen[b] = true;
            }
        for(int b=0; b < N; b++)
            if(!seen[b])
                order.add(b);
        long res = 0L;
        for(int b: books)
        {
            int sum = 0;
            for(int i=0; i < N; i++)
            {
                if(order.get(i) == b)
                {
                    res += sum;
                    order.remove(i);
                    order.add(0, b);
                    break;
                }
                sum += arr[order.get(i)];
            }
        }
        System.out.println(res);
    }
    public static int[] readArr(int N, BufferedReader infile, StringTokenizer st) throws Exception
    {
        int[] arr = new int[N];
        st = new StringTokenizer(infile.readLine());
        for(int i=0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        return arr;
    }
}