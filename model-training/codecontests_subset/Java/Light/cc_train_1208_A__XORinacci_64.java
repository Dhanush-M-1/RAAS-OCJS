
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tc = in.nextInt();
        for (int t = 0; t < tc; t++) {
            int a = in.nextInt(), b = in.nextInt(), n = in.nextInt();
            switch (n % 3) {
                case 0:
                    System.out.println(a);
                    break;
                case 1:
                    System.out.println(b);
                    break;
                case 2:
                    System.out.println(a ^ b);
                    break;
            }
        }//fortc
    }//psvm
}//class
