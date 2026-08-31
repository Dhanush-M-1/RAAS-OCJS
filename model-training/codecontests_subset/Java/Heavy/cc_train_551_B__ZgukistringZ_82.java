import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        String a = in.readLine();
        String b = in.readLine();
        String c = in.readLine();
        int[] freqA = new int[26];
        int[] freqB = new int[26];
        int[] freqC = new int[26];
        for (int i = 0; i < a.length(); i++) freqA[a.charAt(i)-'a']++;
        for (int i = 0; i < b.length(); i++) freqB[b.charAt(i)-'a']++;
        for (int i = 0; i < c.length(); i++) freqC[c.charAt(i)-'a']++;

        int res = 0;
        int amB = 0;
        int amC = 0;
        outer: for (int i = 0; i <= 1e5; i++) {
            int[] freq = Arrays.copyOf(freqA, 26);
            for (int j = 0; j < 26; j++) {
                if (freq[j] < i*freqB[j]) {
                    break outer;
                }
                freq[j] -= i*freqB[j];
            }
            int limit = Integer.MAX_VALUE;
            for (int j = 0; j < 26; j++) {
                if (freqC[j] > 0) {
                    limit = Math.min(limit, freq[j] / freqC[j]);
                }
            }
            int count = limit+i;
            if (count > res) {
                res = count;
                amB = i;
                amC = limit;
            }
        }
        int[] freq = Arrays.copyOf(freqA, 26);
        for (int i = 0; i < 26; i++) {
            freq[i] -= amB*freqB[i] + amC*freqC[i];
        }
        for (int i = 0; i < amB; i++) out.print(b);
        for (int i = 0; i < amC; i++) out.print(c);
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < freq[i]; j++) {
                out.print((char)(i+'a'));
            }
        }
        out.print('\n');
        out.close();
    }

}

/*
azaza
v
a


 */