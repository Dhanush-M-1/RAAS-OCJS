import java.util.Scanner;

public class RequiredRemainder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int num = input.nextInt();

        for (int i = 0; i < num; i++) {
            int temp = input.nextInt();
            int count = 0;
            int multcount = 0;
            while (temp != 1) {
                if (temp % 6 == 0) {
                    multcount = 0;
                    temp /= 6;
                } else {
                    multcount++;
                    if (multcount == 3) {
                        System.out.println(-1);
                        break;
                    }
                    temp *= 2;
                }
                count++;
            }
            if (multcount != 3)
                System.out.println(count);
        }
    }
}
