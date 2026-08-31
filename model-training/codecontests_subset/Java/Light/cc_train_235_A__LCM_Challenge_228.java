
import java.util.Scanner;


public class A235 {
    
    public static long gcd(long a, long b){
        if(b==0)return a;
        return gcd(b, a%b);
    }
    
    public static void main(String[] args)throws Exception{
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int ans = -1;
        if(n==1)ans = 1;
        else if(n==2)ans = 2;
        else if(n==3)ans = 6;
        if(ans!=-1){System.out.println(ans);return;}
        if(n%2==1){
            System.out.println((long)n*(n-1)*(n-2));
        }else{
            long max = Integer.MIN_VALUE;
            for(int i=n-5;i<=n;++i){
                if(i<1)continue;
                for(int j=i;j<=n;++j){
                    if(j<1)continue;
                    //System.out.println("Seeing for "+i+", "+j+", "+n);
                    long N = ((long)i*j)/gcd(i, j);
                    long cur = (N*n)/gcd(N, n);
                    if(cur>max)max=cur;
                }
            }
            if((long)(n-1)*(n-2)*(n-3) > max)max = (long)(n-1)*(n-2)*(n-3);
            System.out.println(max);
        }
    }
}
