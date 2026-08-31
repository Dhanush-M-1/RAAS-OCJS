

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void reverse(char[] a) {
        for (int i = 0; i < a.length/2; i++) {
            char temp = a[i];
            a[i] = a[a.length-i-1];
            a[a.length-i-1] = temp;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();

        char[] num = sc.next().toCharArray();
        reverse(num);

        int answer = 0;

        for (int i = 0; i < x; i++) {
            if (i != y && num[i] != '0')
                answer  += 1;
            if (i == y && num[i] != '1')
                answer += 1;
        }

        System.out.println(answer);
    }
}
