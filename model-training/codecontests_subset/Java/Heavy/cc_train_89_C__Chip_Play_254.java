import static java.util.Arrays.*;
import static java.lang.Math.*;
import static java.math.BigInteger.*;
import java.util.*;
import java.math.*;
import java.io.*;

public class C implements Runnable
{
    String file = "input";
    
    boolean TEST = false;
    
    void solve() throws IOException
    {
        int rn = nextInt(), cn = nextInt();
        char[][] cs = new char[rn][];
        for(int i = 0; i < rn; i++) cs[i] = next().toCharArray();
        Node[][] sample = new Node[rn][cn];
        Node[][] a = new Node[rn][cn];
        
        for(int i = 0; i < rn; i++) 
            for(int j = 0; j < cn; j++)
            {
                if(cs[i][j] == '.') continue;
                int left = -1;
                for(int k = j - 1; k >= 0; k--)
                    if(cs[i][k] != '.')
                    {
                        left = k;
                        break;
                    }
                int right = -1;
                for(int k = j + 1; k < cn; k++)
                    if(cs[i][k] != '.')
                    {
                        right = k;
                        break;
                    }
                int up = -1;
                for(int k = i - 1; k >= 0; k--)
                    if(cs[k][j] != '.')
                    {
                        up = k;
                        break;
                    }
                int down = -1;
                for(int k = i + 1; k < rn; k++)
                    if(cs[k][j] != '.')
                    {
                        down = k;
                        break;
                    }
                sample[i][j] = new Node(left, right, up, down);
                a[i][j] = new Node(left, right, up, down);
            }
        int[] count = new int[10000];
        for(int i = 0; i < rn; i++)
            for(int j = 0; j < cn; j++)
            {
                if(cs[i][j] == '.') continue;
                for(int x = 0; x < rn; x++)
                    for(int y = 0; y < cn; y++)
                        if(sample[x][y] != null)
                            a[x][y].assign(sample[x][y]);
                
                int cx = i, cy = j, step = 0;
                while(cx != -1 && cy != -1)
                {
                    step++;
                    if(a[cx][cy].left != -1) a[cx][a[cx][cy].left].right = a[cx][cy].right;
                    if(a[cx][cy].right != -1) a[cx][a[cx][cy].right].left = a[cx][cy].left;
                    if(a[cx][cy].up != -1) a[a[cx][cy].up][cy].down = a[cx][cy].down;
                    if(a[cx][cy].down != -1) a[a[cx][cy].down][cy].up = a[cx][cy].up;
                    
                    char c = cs[cx][cy];
                    if(c == 'U') cx = a[cx][cy].up;
                    else if(c == 'D') cx = a[cx][cy].down;
                    else if(c == 'L') cy = a[cx][cy].left;
                    else cy = a[cx][cy].right;
                }
                count[step]++;
            }
        for(int i = 9999; i >= 0; i--)
            if(count[i] > 0)
            {
                out.println(i + " " + count[i]);
                return;
            }
    }
    
    class Node
    {
        int left, right, up, down;
        
        Node(int left, int right, int up, int down)
        {
            this.left = left;
            this.right = right;
            this.up = up;
            this.down = down;
        }
        void assign(Node a)
        {
            left = a.left;
            right = a.right;
            up = a.up;
            down = a.down;
        }
    }
    
    String next() throws IOException
    {
        while(st == null || !st.hasMoreTokens()) st = new StringTokenizer(input.readLine());
        return st.nextToken();
    }
    
    int nextInt() throws IOException
    {
        return Integer.parseInt(next());
    }
    
    long nextLong() throws IOException
    {
        return Long.parseLong(next());
    }
    
    double nextDouble() throws IOException
    {
        return Double.parseDouble(next());
    }
    
    void print(Object... o)
    {
        System.out.println(deepToString(o));
    }
    
    void gcj(Object o)
    {
        String s = String.valueOf(o);
        out.println("Case #" + test + ": " + s);
        System.out.println("Case #" + test + ": " + s);
    }
    
    BufferedReader input;
    PrintWriter out;
    StringTokenizer st;
    int test;
    
    void init() throws IOException
    {
        if(TEST) input = new BufferedReader(new FileReader(file + ".in")); 
        else input = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new BufferedOutputStream(System.out));
    }
    
    public static void main(String[] args) throws IOException
    {
        new Thread(null, new C(), "", 1 << 20).start();
    }
    
    public void run()
    {
        try
        {
            init();
            if(TEST) 
            {
                int runs = nextInt();
                for(int i = 0; i < runs; i++) solve();
            }
            else solve();
            out.close();        
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.exit(1);
        }
    }
}