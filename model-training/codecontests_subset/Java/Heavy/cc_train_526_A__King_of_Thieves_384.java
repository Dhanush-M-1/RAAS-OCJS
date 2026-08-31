import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class A {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String s = scan.next();
        int start = s.indexOf('*');
        if (start == -1) {
            System.out.println("no");
            System.exit(0);
        }
        while (start != -1) {
            for (int i = 1; i < n; i++) {
                boolean w = true;
                int it = 0;
                int c = i;
                while (true) {
                    it++;
                    if (start + c >= n || s.charAt(start + c) != '*') {
                        //System.out.println(start + " " + i);
                        w = false;
                        break;
                    }
                    c = c + i;
                    if (it == 4)
                        break;
                }
                if (w) {
                    System.out.println("yes");
                    System.exit(0);
                }
                // System.out.println(start);
            }
            start = s.indexOf('*', start + 1);
        }
        System.out.println("no");
    }
}