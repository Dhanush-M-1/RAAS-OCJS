import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static java.lang.System.*;

public class Main
{
    public static void main(String[] args) {
        Scanner s = new Scanner(in);
        int t = s.nextInt();

        while (t-- > 0) {
            int n = s.nextInt();
            int prevPlay = 0;
            int prevClear = 0;
            boolean isIncorrect = false;
            while (n-- > 0) {
                int plays = s.nextInt();
                int clears = s.nextInt();
                if (isIncorrect) continue;
                if (prevPlay > plays || prevClear > clears || clears - prevClear > plays - prevPlay) {
                    out.println("NO");
                    isIncorrect = true;
                    continue;
                }
                prevPlay = plays;
                prevClear = clears;
            }
            if (!isIncorrect) out.println("YES");
        }
    }
}