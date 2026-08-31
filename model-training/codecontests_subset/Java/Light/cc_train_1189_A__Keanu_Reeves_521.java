import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();

        int ones = 0, zeores = 0, cut = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0')
                zeores++;
            else
                ones++;

            if ((ones != zeores) && (cut == -1))
                cut = i + 1;
        }
        if (ones != zeores) {
            System.out.println("1\n" + s);
        } else {
            System.out.println("2\n" + s.substring(0, cut) + " " + s.substring(cut));
        }


    }
}