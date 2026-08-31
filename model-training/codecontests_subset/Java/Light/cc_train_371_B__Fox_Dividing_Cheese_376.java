import java.util.Scanner;

public class B741 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long a = in.nextLong();
        long b = in.nextLong();
        int countA[] = new int[6];
        int countB[] = new int[6];
        long result = 0;
        for (int i = 2; i <= 5; ++i) {
            while (a % i == 0) {
                countA[i]++;
                a /= i;
            }
            while (b % i == 0) {
                countB[i]++;
                b /= i;
            }
            result += Math.abs(countA[i] - countB[i]);
        }
        if (a != b) {
            System.out.println(-1);
            return;
        }
        System.out.println(result);

    }
}
