//package arbuz;

import java.util.Scanner;

public class Arbuz {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int need = y * n;
        if (need % 100 != 0) {
            need = need / 100 + 1;
        } else {
            need = need / 100;
        }
        int clones = need - x;
        if (clones < 0) {
            clones = 0;
        }
        System.out.println(clones);
    }
}
