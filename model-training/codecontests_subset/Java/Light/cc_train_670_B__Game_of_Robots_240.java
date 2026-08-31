//package CF670;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int i = 0;
        int sum = 0;

        while (sum < k) {
            i++;
            sum += i;
        }
        sum -= i;
//        System.out.println(sum);
//        i--;
//        System.out.println(i);
        double index = k - sum;
//        System.out.println(index);
        for (int j = 1; j < index; j++) {
            in.nextInt();
        }
        System.out.println(in.nextInt());
    }
}