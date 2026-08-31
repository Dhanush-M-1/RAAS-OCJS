import java.util.Scanner;

public class Main {
    private static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
	// write your code here

        int t = s.nextInt();
        while(t-->0)
        {
            int n = s.nextInt();

            solve(n);

        }
    }

    private static void solve(int n) {

        if (n == 1)
            System.out.println(0);

        else {
            int cnt3 = 0;
            int cnt2 = 0;
            int temp = n;
            while (temp % 3 == 0) {

                temp /= 3;
                cnt3++;

            }


            while (temp % 2 == 0) {
                temp /= 2;
                cnt2++;

            }
            if (temp != 1) {
                System.out.println(-1);
                return;
            } else {
                if (cnt3 == cnt2) {
                    System.out.println(cnt3);

                } else if (cnt3 > cnt2) {
                    System.out.println((cnt3 - cnt2) + (cnt3));

                } else {
                    System.out.println(-1);
                }


            }


        }

    }

}