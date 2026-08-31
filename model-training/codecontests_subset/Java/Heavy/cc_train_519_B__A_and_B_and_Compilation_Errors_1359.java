import com.sun.javafx.image.IntPixelGetter;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

    public static void f(int[] a, int[] b, int[] c) {
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);

        int index = 0;
        boolean found = false;
        while (index <= b.length-1) {
            if (a[index] != b[index]) {
                found = true;
                break;
            }
            index++;
        }
        if (found) System.out.println(a[index]);
        else System.out.println(a[a.length-1]);

        index = 0;
        found = false;
        while (index <= c.length-1) {
            if (b[index] != c[index]) {
                found = true;
                break;
            }
            index++;
        }
        if (found) System.out.print(b[index]);
        else System.out.print(b[b.length-1]);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[n-1];
        int[] c = new int[n-2];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        for (int i = 0; i < n-1; i++) {
            b[i] = in.nextInt();
        }
        for (int i = 0; i < n-2; i++) {
            c[i] = in.nextInt();
        }
            f(a, b, c);
    }
}