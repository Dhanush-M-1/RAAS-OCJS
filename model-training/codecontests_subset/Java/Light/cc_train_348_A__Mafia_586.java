import java.util.Arrays;
import java.util.Scanner;

public class Mafia {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        double sum = 0;
        int[] rounds = new int[n];
        for (int i = 0; i < n; i++) {
            rounds[i] = cin.nextInt();
            sum += rounds[i];
        }
        cin.close();
        Arrays.sort(rounds);
        System.out.println((int) Math.max(Math.ceil(sum / (n - 1)),
                rounds[n - 1]));
    }
}