import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < N; ++i) {
            String[] array = scanner.nextLine().split(" ");
            long A = Long.parseLong(array[0]);
            long B = Long.parseLong(array[1]);
            long C = Long.parseLong(array[2]);
            long D = Long.parseLong(array[3]);

            if (A < B) {
                System.out.println("No");
            } else if (D < B) {
                System.out.println("No");
            } else if (D % B == 0) {
                if (A % B > C) {
                    System.out.println("No");
                } else {
                    System.out.println("Yes");
                }
            } else {
                long lcm = B;
                long b = D % lcm;
                while (b != 0) {
                    long temp = lcm;
                    lcm = b;
                    b = temp % lcm;
                }

                if (B - lcm <= C) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }
        }
    }
}