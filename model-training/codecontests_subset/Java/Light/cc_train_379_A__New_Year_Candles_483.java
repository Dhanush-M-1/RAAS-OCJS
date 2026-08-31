import java.util.*;
public class Sample {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int count = n;
        while(n >= m) {
            count += (n / m);
            n = (n / m) + (n % m);
        }
        System.out.println(count);
    }
}