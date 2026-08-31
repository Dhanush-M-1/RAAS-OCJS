import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);

        int r1 = scan.nextInt();
        int r2 = scan.nextInt();
        int c1 = scan.nextInt();
        int c2 = scan.nextInt();
        int d1 = scan.nextInt();
        int d2 = scan.nextInt();

        int n1;
        int n2;
        int n3;
        int n4;

        for (int i = 1; i <= 9; i++) {
            n1 = i;
            n2 = r1 - n1;

            if (c1 - n1 == d2 - n2 &&
                    c2 - n2 == d1 - n1 &&
                    r2 - (c1 - n1) == c2 - n2 &&

                    n1 != n2 &&
                    n1 != c1 - n1 &&
                    n1 != c2 - n2 &&
                    n2 != c1 - n1 &&
                    n2 != c2 - n2 &&
                    c1 - n1 != c2 - n2 &&

                    n2 < 10 &&
                    c1 - n1 < 10 &&
                    c2 - n2 < 10 &&

                    n2 != 0 &&
                    c1 - n1 != 0 &&
                    c2 - n2 != 0
                    ) {

                n3 = c1 - n1;
                n4 = d1 - n1;

                System.out.print(n1 + " " +
                        n2 + "\n" +
                        n3 + " " +
                        n4);

                return;
            }
        }

        System.out.print("-1");


        scan.close();


    }
}
