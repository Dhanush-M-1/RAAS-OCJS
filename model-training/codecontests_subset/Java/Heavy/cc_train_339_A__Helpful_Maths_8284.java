import java.util.*;
import java.io.*;
import java.lang.*; 
public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String sum = scan.nextLine();
        int[] counts = new int[4];
        for (int i = 0; i < sum.length(); i++) {
            char c = sum.charAt(i);
            if (c != '+')
                counts[Character.getNumericValue(c)]++;
        }
        StringBuilder out = new StringBuilder();
        for (int i = 1; i <= 3; i++) {
            int count = counts[i];
            String is = Integer.toString(i);
            for (int j = 0; j < count; j++) {
                out.append(is + "+");
            }
        }
        System.out.println(out.toString().substring(0, out.length() - 1));
    }
}