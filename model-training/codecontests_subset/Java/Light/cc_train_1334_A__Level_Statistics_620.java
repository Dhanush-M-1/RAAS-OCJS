//package Coding;

import java.io.*;
import java.util.*;

public class CodeForces {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int i = 0; i < t; ++i) {
            int n = in.nextInt();
            String ans = "YES";
            int game = in.nextInt();
            int clear = in.nextInt();
            if (clear > game) {
                ans = "NO";
            }
            for (int j = 1; j < n; j++) {
                int nextGame = in.nextInt();
                int nextClear = in.nextInt();
                if (nextGame < game || nextClear < clear) {
                    ans = "NO";
                }
                if (nextGame - game < nextClear - clear) {
                    ans = "NO";
                }
                game = nextGame;
                clear = nextClear;
            }
            System.out.println(ans);
        }
    }


}










