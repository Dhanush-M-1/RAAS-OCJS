import java.util.PriorityQueue;
import java.util.Scanner;

public class B {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int tt = 1;
        tt = sc.nextInt();
        while (tt-- > 0) {
         solve();
        }
    }
static int ans[];
    private static void solve() {
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++)
        {
            a[i]=sc.nextInt();
        }
        ans=new int[n];
        btree(0, n - 1, 0,a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }

    private static void btree(int i, int j, int h,int a[]) {
        if (i > j)
            return;
        int mnum = i;
        for (int k = i; k < j + 1; k++) {
            if (a[mnum] < a[k])
                mnum = k;
        }
        ans[mnum] = h;
        btree(i, mnum - 1, h + 1,a);
        btree(mnum + 1, j, h + 1,a);
    }

    private static int recur(int a, int b) {
        if(a==0)
        return 0;
        int an1=Integer.MAX_VALUE;
        if(b!=1)
        an1=recur(a/b,b);
        b++;
       int an2= recur(a,b);
       return Math.min((an1==Integer.MAX_VALUE)?an1:(an1+1),(an2==Integer.MAX_VALUE)?an2:(an2+2));
    }
}