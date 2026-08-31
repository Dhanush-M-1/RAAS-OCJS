import java.io.*;
import java.util.*;


public class C
{
    public static void main(String[] args) throws IOException
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int [] w = new int[n];
        for(int i = 0 ; i < n ; i++)
            w[i] = in.nextInt();

        int [] order = new int[m];

        for(int i = 0 ; i < m ; i++)
            order[i] = in.nextInt() - 1;

        long res = 0;

        for(int i = 0 ; i < m ; i++)
        {
            boolean [] visited = new boolean[n];

            int j = i-1;
            while(j >= 0)
            {
                if(order[j] == order[i])
                    break;
                if(visited[order[j]])
                {
                    j--;
                    continue;
                }

                visited[order[j]] = true;
                res += w[order[j]];
                j--;
            }
        }

        System.out.println(res);

    }
}