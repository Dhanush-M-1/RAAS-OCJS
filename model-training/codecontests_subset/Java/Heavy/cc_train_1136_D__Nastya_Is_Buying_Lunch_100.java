import java.io.*;
import java.util.*;

public class D
{
    PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    // Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public void go() throws IOException
    {
        StringTokenizer tok = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(tok.nextToken());
        int m = Integer.parseInt(tok.nextToken());
        int[] arr = new int[n];
        tok = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++)
        {
            arr[i] = Integer.parseInt(tok.nextToken());
        }
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < m; i++)
        {
            tok = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(tok.nextToken());
            int b = Integer.parseInt(tok.nextToken());
            if (!map.containsKey(a))
            {
                map.put(a, new HashSet<>());
            }
            map.get(a).add(b);
        }

        int nat = arr[n-1];
        for (int i = n-1; i >= 0; i--)
        {
            int j = i;
            while (j < n-1 && map.containsKey(arr[j]) && map.get(arr[j]).contains(arr[j+1]))
            {
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
                j++;
            }
        }
        
        for (int i = 0; i < n; i++)
        {
            if (arr[i] == nat)
            {
                out.println(n-i-1);
            }
        }

        out.flush();
        in.close();
    }

    public static void main(String[] args) throws IOException
    {
        new D().go();
    }
}
