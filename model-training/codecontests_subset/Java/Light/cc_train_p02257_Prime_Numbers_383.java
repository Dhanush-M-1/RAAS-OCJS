import java.util.*;

public class Main {
    private static final Scanner scn = new Scanner(System.in);
    
    public static void main(String[] args) {
        int c = 0, n = scn.nextInt();
        for(int i = 0; i < n; i++) {
            c += primeCheck(scn.nextInt());
        }
        System.out.println(c);
    }
    
    private static int primeCheck(int x) {
        int rslt = 1;
        if(x < 2 || x > 3 && x % 2 == 0) {
            rslt = 0;
        }
        for(int i = 3; i <= x / i; i += 2) {
            if(x % i == 0) {
                rslt = 0;
                break;
            }
        }
        return rslt;
    }
}