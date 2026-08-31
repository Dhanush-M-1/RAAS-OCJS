import java.util.*;
import java.lang.*;
public class Codeforces {
    static Scanner sr = new Scanner(System.in);
    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
    static void cal(int a[],int b[],int l,int r,int c)
    {
        if(l==r)
            return;
        int max=a[l],pos=l;
        for(int i=l+1;i<r;i++)
        {
            if(a[i]>max)
            {
                max=a[i];
                pos=i;
            }
        }
        b[pos]=c;
            cal(a,b,pos+1,r,c+1);
            cal(a,b,l,pos,c+1);
    }
    public static void main(String[] args) throws java.lang.Exception {
        int T=sr.nextInt();
        StringBuffer ans=new StringBuffer();
        while(T-->0)
        {
            int n=sr.nextInt();
            int a[]=new int[n];
            for(int i=0;i<n;i++)
                a[i]=sr.nextInt();
            int c[]=new int[n];
            cal(a,c,0,n,0);
            for(int i=0;i<n;i++)
                ans.append(c[i]+" ");
            ans.append('\n');
        }
        System.out.println(ans);

    }
}