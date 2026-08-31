import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        int k = in.nextInt();

        for (int i = 1; i < k; i++) {
            for (int j = 1; j < k; j++) {
                System.out.printf("%s ", Integer.toString(i * j, k));
            }

            System.out.println();
        }
    }
}