import java.util.*;
public class file {

    private static Scanner scn = new Scanner(System.in);


    private static void foo() {
        int n = scn.nextInt();
        int c_2 = 0;
        int c_3 = 0;
        while(n >= 0) {
            if (n%2 == 0) {
                c_2++;
                n /= 2;
            } else if (n%3 == 0) {
                c_3++;
                n /= 3;
            } else if (n == 1) {
                break;
            } else {
                System.out.println(-1);
                return;
            }
            
        }
        //System.out.printf("%d + %d", c_2, c_3);
        if (c_2 > c_3) {
            System.out.println(-1);
            return;
        }
        System.out.println(c_3-c_2+c_3);




    }

    public static void main(String[] args) {
        int cas = scn.nextInt();
        while(cas-- > 0) foo();
    }
}