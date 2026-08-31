import java.util.Scanner;

public class sas {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        long t=scanner.nextLong();
        long ans=1;
        for (long i = 1; i*i <=t ; i++) {
            if(t%i==0&&(t/(gcd(i,t/i)))==t){
                ans=i;
            }
        }
        System.out.println(ans+" "+t/ans);
    }
    public static long gcd(long a,long b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
}
