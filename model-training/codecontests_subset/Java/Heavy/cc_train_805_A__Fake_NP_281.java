import java.util.HashMap;
import java.util.Scanner;

public class A805 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long a = input.nextLong();
        long b = input.nextLong();
        int[] primes = { 2, 3, 5, 7, 11 };
        HashMap<Integer, Integer> lst = new HashMap<Integer, Integer>();
        if (b - a >= 3) {
            System.out.println(2);
        }else if(b == a){
            System.out.println(a);
        }
        else {
            for (long i = a; i <= b; i++) {
                for (int j = 0; j < 5; j++) {
                    if (i % primes[j] == 0) {
                        if (lst.containsKey(primes[j])) {
                            lst.put(primes[j], lst.get(primes[j]) + 1);
                        } else {
                            lst.put(primes[j], 1);
                        }
                    }
                }
            }
            int max = 2;
            for (int x : lst.keySet()) {
                if (lst.get(max) < lst.get(x)) {
                    max = x;
                }
            }
            System.out.println(max);
        }
    }
}