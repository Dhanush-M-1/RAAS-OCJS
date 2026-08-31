


import java.util.Scanner;

public class A {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        for (int i = 0; i < n; ++i) {
            for (int j = 1; i + 4 * j < n; ++j) {
                boolean flag = true;
                for (int k = 0; k < 5; ++k) {
                    if (s.charAt(i + k * j) != '*') {
                        flag = false;
                    }
                }
                if (flag) {
                    System.out.print("yes");
                    return;
                }
            }
        }

//        System.out.println(lastCount);
        System.out.print("no");
    }
}