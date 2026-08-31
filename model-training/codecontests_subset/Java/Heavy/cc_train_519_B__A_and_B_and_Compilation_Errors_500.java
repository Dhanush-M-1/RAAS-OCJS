import java.util.Scanner;

public class CompilationErrors {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int error1 = 0, error2 = 0;
        long sum = 0;
        for (int i = 0; i < 3; i++) {
            long currSum = 0;
            for (int j = 0; j < n; j++) {
                currSum += reader.nextLong();
            }
            if (i == 1) {
                error1 = (int) (sum - currSum);
                System.out.println(error1);
            }
            if (i == 2) {
                error2 = (int) (sum - currSum);
                System.out.println(error2);
            }
            sum = currSum;
            n--;
        }
    }
}
