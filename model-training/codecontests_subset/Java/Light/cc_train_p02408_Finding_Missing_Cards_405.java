import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        HashMap<String, Integer> sn = new HashMap<String, Integer>();
        sn.put("S", 0);
        sn.put("H", 1);
        sn.put("C", 2);
        sn.put("D", 3);
        char[] ns = new char[]{'S', 'H', 'C', 'D'};

        int n = s.nextInt();
        boolean[][] c = new boolean[4][13];
        for(int i = 0; i < c.length; ++i) {
            for(int j = 0; j < c[0].length; ++j) {
                c[i][j] = false;
            }
        }
        for(int i = 0; i < n; ++i) {
            c[sn.get(s.next())][s.nextInt() - 1] = true;
        }

        for(int i = 0; i < c.length; ++i) {
            for(int j = 0; j < c[0].length; ++j) {
                if(c[i][j] == false) System.out.println(ns[i] + " " + (j + 1));
            }
        }
    }
}