import java.io.*;
import java.util.*;

public class Codeforces
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        char a[]=bu.readLine().toCharArray(),b[]=bu.readLine().toCharArray();
        int n=a.length,m=b.length;
        if(n!=m) {System.out.print("NO"); return;}

        boolean pos=divide(a,b,0,n-1,0,n-1);
        if(pos) sb.append("YES");
        else sb.append("NO");
        System.out.print(sb);
    }

    static boolean divide(char a[],char b[],int l1,int r1,int l2,int r2)
    {
        int len=(r1-l1+1),i;
        boolean eq=true;
        for(i=0;i<len;i++)
        if(a[l1+i]!=b[l2+i]) {eq=false; break;}
        if(len%2==1 || eq) return eq;
        if(len==2) return (a[l1]==b[l2] && a[r1]==b[r2]) || (a[r1]==b[l2] && a[l1]==b[r2]);

        len/=2;
        return (divide(a,b,l1,l1+len-1,l2,l2+len-1) && divide(a,b,l1+len,r1,l2+len,r2)) || (divide(a,b,l1,l1+len-1,l2+len,r2) && divide(a,b,l1+len,r1,l2,l2+len-1));
    }
}
