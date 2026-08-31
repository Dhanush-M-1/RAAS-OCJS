import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] hosts = new int[150];
        int[] guests = new int[150];

        int c = 0;

        for (int i = 0; i < n; i++) {
            int h = in.nextInt();
            int g = in.nextInt();
            c += hosts[g] + guests[h];
            hosts[h]++;
            guests[g]++;
        }

        System.out.println(c);
    }
}