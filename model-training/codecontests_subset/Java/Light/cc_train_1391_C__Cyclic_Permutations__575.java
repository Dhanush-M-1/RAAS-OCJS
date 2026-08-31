import java.util.Arrays;
import java.util.Scanner;
public class Main {


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long mod=(int)1e9+7;
        int n=s.nextInt();
        long ans=1;
        for (int i=1;i<=n;i++)ans=(ans*i)%mod;
        long twoPower=1;
        for (int i=1;i<n;i++)twoPower=(twoPower*2)%mod;
        System.out.println((ans-twoPower+mod)%mod);
    }

}