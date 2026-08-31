

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] S = in.readLine().split(" ");
        int t = Integer.parseInt(S[0]);
        int m = Integer.parseInt(S[1]);
        boolean[] O = new boolean[m];
        int[] P = new int[t];
        int[] Rp = new int[m];
        Arrays.fill(Rp, -1);
        int[] Si = new int[t];
        int c = 0;
        while (t-- > 0) {
            S = in.readLine().split(" ");
            if (S[0].equals("defragment")) {
                int start = 0;
                Arrays.fill(O, false);
                for (int i = 0; i < m; i++) {
                    if (Rp[i] != -1) {
                        for (int j = start; j < start + Si[Rp[i]]; j++)
                            O[j] = true;
                        P[Rp[i]] = start;
                        Rp[start] = Rp[i];
                        start += Si[Rp[i]];
                        if (i != P[Rp[i]])
                            Rp[i] = -1;
                    }
                }
            }
            if (S[0].equals("erase")) {
                int index = Integer.parseInt(S[1]) - 1;
                if (index >= c || index < 0 || P[index] == -1)
                    System.out.println("ILLEGAL_ERASE_ARGUMENT");
                else {
                    for (int i = P[index]; i < P[index] + Si[index]; i++)
                        O[i] = false;
                    Rp[P[index]] = -1;
                    P[index] = -1;
                }
            }
            if (S[0].equals("alloc")) {
                int size = Integer.parseInt(S[1]);
                boolean done = false;
                for (int i = 0; i + size <= m; i++) {
                    boolean can = true;
                    for (int j = i; j < i + size; j++)
                        can &= !O[j];
                    if (can) {
                        for (int j = i; j < i + size; j++)
                            O[j] = true;
                        P[c] = i;
                        Rp[i] = c;
                        Si[c] = size;
                        System.out.println(++c);
                        done = true;
                        break;
                    }
                }
                if (!done)
                    System.out.println("NULL");
            }
        }
    }
}