import java.util.ArrayList;
import java.util.Scanner;

public class java2 {
    static Scanner r = new Scanner(System.in);
    static int[] p,c;
    static ArrayList<Integer>[] g;
    public static void main(String[] args) {
        int n=r.nextInt();
        int m=r.nextInt();
        p=new int[n+1];
        c=new int[n+1];
        g=(ArrayList<Integer>[]) new ArrayList[n+1];
        for(int i=1;i<=n;++i)
        {
            g[i]=new ArrayList<>();
            p[i]=r.nextInt();
        }
        for(int i=1;i<=m;++i)
        {
            int u=r.nextInt();
            int v=r.nextInt();
            g[v].add(u);
        }
        int ans=0;
        for(int i=n;i>=1;--i)
        {
            if(c[p[i]]==n-i-ans&&i!=n) ++ans;
            else for(int v:g[p[i]]) ++c[v];
        }
        System.out.println(ans);
    }
}
