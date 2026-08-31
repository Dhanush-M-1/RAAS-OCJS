import java.io.*;
import java.text.*;
import java.math.*;
import java.util.*;

public class Main {

    private StreamTokenizer in;
    private BufferedWriter out;

    public void solve() throws Exception {
        int t = nextInt(), n = nextInt();
        int[] mem = new int[n];
        int cur = 0;
        main:while (t-->0)
        {
            in.nextToken();
            String cmd = in.sval;
            if (cmd.equals("defragment"))
            {
                int k = 0;
                for (int i=0; i<n; i++)
                    if (mem[i]>0)
                        mem[k++] = mem[i];
                for (int i=k; i<n; i++)
                    mem[i] = 0;
                continue;
            }
            int param = nextInt();
            if (cmd.equals("alloc"))
            {
                cycle:for (int i=0; i<n-param+1; i++)
                {
                    for (int j=i; j<i+param; j++)
                        if (mem[j]>0) continue cycle;
                    cur++;
                    for (int j=i; j<i+param; j++)
                        mem[j] = cur;
                    out.write(cur+"\n");
                    continue main;
                }
                out.write("NULL\n");
                continue;
            }
            if (cmd.equals("erase"))
            {
                if (param==0)
                {
                    out.write("ILLEGAL_ERASE_ARGUMENT\n");
                    continue;
                }
                int c = 0;
                for (int i=0; i<n; i++)
                    if (mem[i]==param)
                    {
                        c++;
                        mem[i] = 0;
                    }
                if (c==0)
                    out.write("ILLEGAL_ERASE_ARGUMENT\n");
            }
        }
    }
    
    public int nextInt() throws Exception
    {
        in.nextToken();
        if (in.nval<Integer.MIN_VALUE || in.nval>Integer.MAX_VALUE)
            return Integer.MIN_VALUE;
        return (int)in.nval;
    }

    public void run() {
        try {
            in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
            out = new BufferedWriter(new OutputStreamWriter(System.out));
            solve();
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        new Main().run();
    }
}