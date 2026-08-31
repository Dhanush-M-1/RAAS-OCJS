import java.util.*;
public class S{
    public static void main(String args[]){
        long mod=1000000007;
        Scanner scan=new Scanner(System.in);
            long n=scan.nextInt();
            long ans=1;
            for(int i=1;i<=n;i++){
                ans=(ans*i)%mod;
            }
            long sub=4;
            //System.out.println(ans);
            for(int i=4;i<=n;i++){
                sub=(sub*2)%mod;
            }
            System.out.println((ans-sub+mod)%mod);
    }
}