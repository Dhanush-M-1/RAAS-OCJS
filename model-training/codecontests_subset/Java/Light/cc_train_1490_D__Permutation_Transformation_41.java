import java.util.*;
import java.math.*;
public class Main {
    static int n;
    static int a[];
    static int wei[];
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        while(T-->0)
        {
            HashMap<Integer,Integer>map = new HashMap<>();
            n = input.nextInt();
            a = new int[n+1];
            wei = new int[n+1];
            for(int i=1;i<=n;i++)
            {
                a[i] = input.nextInt();
            }
            dfs(1,n,0);
            for (int i=1; i<=n; i++)
                System.out.print(wei[i]+" ");
            System.out.println();
        }
    }
    static void dfs(int l,int r,int h) {
        if (l>r) return ;
        if (l==r) {
            wei[r]=h;
            return ;
        }
        int maxi=0,maxn=0;
        for (int i=l; i<=r; i++)
            if (maxn<a[i]) {
                maxn=a[i];
                maxi=i;
            }
        wei[maxi]=h;
        dfs(l,maxi-1,h+1);
        dfs(maxi+1,r,h+1);
    }
    }