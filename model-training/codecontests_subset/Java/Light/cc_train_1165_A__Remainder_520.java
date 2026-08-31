/*
Written by Kabir Kanha Arora
@kabirkanha
 */

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        char[] arr = scanner.next().toCharArray();
        int changes = 0;
        for (int i = 0; i < x; ++i) {
            if (i == y) {
                if (arr[n - i - 1] != '1') {
                    changes++;
                }
            } else {
                if (arr[n - i - 1] != '0') {
                    changes++;
                }
            }
        }
        System.out.println(changes);
    }

}
