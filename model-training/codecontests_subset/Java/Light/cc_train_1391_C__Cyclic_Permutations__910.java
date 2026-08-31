import java.util.*;
public class Main{
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int mod = (int)1e9 +7;
        long ans = 1;
        long two = 1;
        for (int i =2; i<=n; i++){
            ans*=i;
            two*=2;
            two%=mod;
            ans%=mod;
        }
        System.out.println((ans-two+mod)%mod);
    }
}