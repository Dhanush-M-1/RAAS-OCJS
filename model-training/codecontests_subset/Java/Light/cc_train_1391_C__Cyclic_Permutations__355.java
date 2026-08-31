import java.util.Scanner;

public final class CyclicPermutation {
    public static int mod= (int) (Math.pow(10,9)+7);
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        long fact=1;
        for(long i=1;i<=n;i++){
            fact=(fact*i)%mod;
        }
        long noCycle=Powr(2,n-1)%mod;
        long ans=(fact-noCycle+mod)%mod;
        System.out.println(ans);

    }

    private static long Powr(long a, int b) {
        if(b==0) return 1;
        if(b%2==0)
            return Powr((a*a)%mod,b/2)%mod;
        else
            return (a%mod)*(Powr(a,b-1)%mod)%mod;
    }
}
