import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

import sun.reflect.generics.tree.Tree;

/**
 * Created by KH1993 on 28-02-2018.
 */

public class TestClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int mid = (a+b)/2;
        if(a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        a = mid - a;
        b = b - mid;
        a = (a*(a+1))/2;
        b = (b*(b+1))/2;
        System.out.println(a+b);
    }
}
