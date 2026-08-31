import java.util.Scanner;

public class CodeForces {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        scanner.close();

        for (int i = 1; i < size; i++) {
            for (int j = 1; j < size; j++) {
                int num = i * j;
                StringBuilder number = new StringBuilder();
                while (num != 0) {
                    int remainder = num % size;
                    num /= size;
                    number.append(String.valueOf(remainder));
                }

                System.out.print(number.reverse());
                System.out.print(" ");
            }
            System.out.print("\n");
        }
    }
}
