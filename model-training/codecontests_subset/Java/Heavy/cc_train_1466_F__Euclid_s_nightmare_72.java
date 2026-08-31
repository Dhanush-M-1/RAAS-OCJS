import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.Math.abs;
import java.util.*;
import java.io.*;

public class x1466F
{
    public static void main(String hi[]) throws Exception
    {
        BufferedReader infile = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(infile.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        DSU union = new DSU(M+1);
        ArrayList<Integer> ls = new ArrayList<Integer>();
        for(int i=0; i < N; i++)
        {
            st = new StringTokenizer(infile.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            int a = 0; int b = Integer.parseInt(st.nextToken());
            if(cnt == 2)
                a = Integer.parseInt(st.nextToken());
            if(union.find(a) != union.find(b))
            {
                ls.add(i+1);
                union.merge(a, b);
            }
        }
        long res = 1L;
        for(int i=0; i < ls.size(); i++)
            res = (res*2)%1000000007L;
        StringBuilder sb = new StringBuilder();
        sb.append(res+" "+ls.size()+"\n");
        for(int x: ls)
            sb.append(x+" ");
        System.out.println(sb);
    }
}
class DSU
{
    public int[] dsu;
    public int[] size;

    public DSU(int N)
    {
        dsu = new int[N+1];
        size = new int[N+1];
        for(int i=0; i <= N; i++)
        {
            dsu[i] = i;
            size[i] = 1;
        }
    }
    public int find(int x)
    {
        return dsu[x] == x ? x : (dsu[x] = find(dsu[x]));
    }
    public void merge(int x, int y)
    {
        int fx = find(x);
        int fy = find(y);
        dsu[fx] = fy;
    }
    public void merge(int x, int y, boolean sized)
    {
        int fx = find(x);
        int fy = find(y);
        size[fy] += size[fx];
        dsu[fx] = fy;
    }
}