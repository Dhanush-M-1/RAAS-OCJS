import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static long [] a = new long[3];
     
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        a[0] = reader.nextLong();
        a[1] = reader.nextLong();
        a[2] = reader.nextLong();
        Arrays.sort(a);
        System.out.println((a[1]-a[0])%2 == 0?a[1]:a[2]);
    }
}