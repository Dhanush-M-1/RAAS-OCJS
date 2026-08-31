import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B_2 {
    private static final int SIZE = 26;

    public static void main(String[] args) {
        String mainString,a,b;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            mainString = br.readLine();
            a = br.readLine();
            b = br.readLine();
            br.close();
        } catch(IOException io) {
            io.printStackTrace();
            return;
        }

        int[] mainCount = getCharsCount(mainString);
        int[] aCount = getCharsCount(a);
        int[] bCount = getCharsCount(b);

        int max = -1;
        int maxX = 0, maxY = 0;
        for (int x = 0; x <= mainString.length(); x++) {
            int y = fitAsManyB(mainCount, aCount, x, bCount);
            if (y < 0) break;
            if (max < x + y) {
                max = x + y;
                maxX = x;
                maxY = y;
            }
        }

        // output stuff
        for (int i = 0; i < SIZE; i++) {
            mainCount[i] -= maxX * aCount[i];
            mainCount[i] -= maxY * bCount[i];
        }

        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            for (int i = 0; i < maxX; i++) {
                bw.write(a);
            }
            for (int i = 0; i < maxY; i++) {
                bw.write(b);
            }

            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < mainCount[i]; j++) {
                    bw.write('a' + i);
                }
            }

            bw.newLine();
            bw.close();
        } catch (IOException e) {
            // ...
        }
    }

    private static int[] getCharsCount(String s) {
        int charMap[] = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            charMap[i] = 0;
        }

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            charMap[c - 'a']++;
        }

        return charMap;
    }

    // return -1 if not possible
    private static int fitAsManyB(int[] source, int[] a, int aCount, int[] b) {
        int maxB = Integer.MAX_VALUE;
        for (int i = 0; i < SIZE; i++) {

            if (source[i] < a[i] * aCount) {
                return -1;
            }

            if (b[i] > 0) {
                maxB = Math.min(maxB, (source[i] - a[i] * aCount) / b[i]);
            }
        }
        return maxB;
    }
}