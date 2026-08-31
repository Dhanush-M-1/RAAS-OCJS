import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A
{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = null;
    
    private void solve() throws IOException
    {
        int n = nextInt();
        int x = nextInt();
        int y = nextInt();
        System.out.println(Math.max((int) Math.ceil((double) n * y / 100) - x, 0));
    }
    
    String nextToken() throws IOException
    {
        if (st == null || !st.hasMoreTokens())
        {
            st = new StringTokenizer(bf.readLine());
        }
        
        return st.nextToken();
    }

    int nextInt() throws IOException
    {
        return Integer.parseInt(nextToken());
    }

    long nextLong() throws IOException
    {
        return Long.parseLong(nextToken());
    }

    double nextDouble() throws IOException
    {
        return Double.parseDouble(nextToken());
    }

    public static void main(String args[]) throws IOException
    {
        new A().solve();
    }
    
}