import java.io.*;
import java.util.Scanner;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        byte c1 = 0, c0 = 0;
        byte n = in.nextByte() ;
        String str = in.next();

        if (str.length() != 1) {

            while (n-- != 0) {
                if (str.charAt(n) == '1')
                    c1++;
                else c0++;
            }
            if (c1 == c0){
                System.out.println(2);
                System.out.print(str.charAt(0) + " " + str.substring(1, str.length()));
            }else {
                System.out.println(1);
                System.out.println(str);
            }

        }else {
            System.out.println(1);
            System.out.println(str.charAt(0));
        }

    }
}
