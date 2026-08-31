import java.util.*;

public class Main {

    static final int INF = 1000000000;
    
    public static int max(int a,int b) {
        return a>b?a:b;
    }
    
    public static int min(int a,int b) {
        return a<b?a:b;
    }
    
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] ord = new int[m+5];
        int[] ls = new int[m+5];
        int[] rs = new int[m+5];
        int[] va = new int[m+5];
        int[] a = new int[n+5];
        int[] b = new int[n+5];
        for(int i=1;i<=n;++i) a[i] = INF;
        for(int i=1;i<=m;++i) {
            ord[i] = in.nextInt();
            ls[i] = in.nextInt();
            rs[i] = in.nextInt();
            va[i] = in.nextInt();
        }
        for(int i=m;i>0;--i) {
            if(ord[i]==1) {
                for(int j=ls[i];j<=rs[i];++j)
                    a[j]-=va[i];
            }
            else {
                for(int j=ls[i];j<=rs[i];++j)
                    if(a[j]>va[i]) a[j]=va[i];
            }
        }
        for(int i=1;i<=n;++i)
            b[i]=a[i]=min(max(a[i],-INF),INF);
        boolean flag=true;
        for(int i=1;i<=m && flag;++i) {
            
            if(ord[i]==1) {
                for(int j=ls[i];j<=rs[i];++j)
                    a[j]+=va[i];
            }
            else {
                int mx=-INF;
                for(int j=ls[i];j<=rs[i];++j)
                    mx=max(mx,a[j]);
                if(mx!=va[i]) flag=false;
            }
        }
        if(flag) {
            System.out.println("YES");
            for(int i=1;i<=n;++i) {
                System.out.print(b[i]);
                if(i<n) System.out.print(" ");
                else System.out.println("");
            }
        }
        else System.out.println("NO");
    }

}
