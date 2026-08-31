import java.util.*;
import java.util.stream.*;
class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n,ans;
        long num;
        n = input.nextInt();
        ans = 0;
        for (int i = 0; i < n; i++){
            num = input.nextLong();
            if (isPrime(num)){
                ans += 1;
            }
        }
        System.out.println(ans);
    }
    public static boolean isPrime(long n){
        for (int i = 2; i*i <= n; i++){
            if (n%i == 0){
                return false;
            }
        }
        return n != 1;
    }
}
