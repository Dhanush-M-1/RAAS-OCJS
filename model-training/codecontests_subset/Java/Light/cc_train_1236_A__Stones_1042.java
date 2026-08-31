import java.util.Scanner;

public class Solution12 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        while (n > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
int sum=0;
            while (c >= 2 && b >= 1) {
                sum += 3;
                c -= 2;
                b -= 1;

            }
            while (b >= 2 && a >= 1) {
                sum += 3;
                b -= 2;
                a -= 1;
            }

            System.out.println(sum);
            n--;
        }

    }
}


