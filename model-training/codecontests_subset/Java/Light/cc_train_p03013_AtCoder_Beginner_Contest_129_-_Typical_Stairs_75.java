import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int a[]=new int[m];
        int b[]=new int[m+1];
        int fib[]=new int[n+2];
        fib[0]=0;
        fib[1]=1;
        for(int i=2;i<n+2;i++){
            fib[i]=fib[i-1]+fib[i-2];
            fib[i]%=1000000007;
        }
        int po=-1;
        for(int i=0;i<m;i++){
            a[i]=sc.nextInt();
            b[i]=a[i]-po-1;
            po=a[i];
        }
        b[m]=n-po;
        long ans=1;
        for(int i=0;i<m+1;i++){
            //System.out.println(b[i]);
            ans*=fib[b[i]];
            ans%=1000000007;
        }
        System.out.println(ans);
    }
}
