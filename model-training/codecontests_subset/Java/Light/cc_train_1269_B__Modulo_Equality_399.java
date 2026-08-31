import java.util.*;
import java.io.*;
public class Main{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        long n=sc.nextInt();
        long m=sc.nextLong();
        long a[]=new long[(int)n];
        long b[]=new long[(int)n];
        for(int i=0;i<(int)n;i++)a[i]=sc.nextLong();
        for(int i=0;i<(int)n;i++)b[i]=sc.nextLong();
        Arrays.sort(b);
        int res=(int)m;
        for(int i=0;i<n;i++){
            int x=((int)b[i]-(int)a[0]+(int)m)%(int)m;
            long tmp[]=new long[(int)n];
            for(int j=0;j<n;j++)tmp[j]=(a[j]+(long)x)%m;
            Arrays.sort(tmp);
            boolean ans=true;
            for(int j=0;j<n;j++)if(tmp[j]!=b[j]){ans=false;}
            if(ans)res=Math.min(res,x);
        }
        System.out.println(res);
    }
}