import java.util.*;
import java.io.*;

public class Phone {

    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        int c8 = 0;
        for (int i = 0; i < n; i++){
            if (s.charAt(i) == '8') c8++;
        }
        System.out.println(Math.min(c8, n/11));
    }

}