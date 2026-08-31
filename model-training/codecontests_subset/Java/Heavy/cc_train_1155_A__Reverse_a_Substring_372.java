

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.LongStream;

public class pa {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = readInt();
        char[] s = readString();
        for (int i = 0; i < n - 1; i++)
            if (s[i] > s[i + 1]) {
                int l = i + 1;
                int  r = i + 2;
                System.out.println("YES");
                System.out.println("" + l + " " + r);
                return;
            }

        System.out.println("NO");
    }

    static int readInt() throws IOException {
        return Integer.parseInt(br.readLine());
    }

    static char[] readString() throws IOException {
        return br.readLine().toCharArray();
    }

    static int[] readArrayInt() throws IOException {
        String s[] = br.readLine().split(" ");
        int a[] = new int[s.length];
        for (int i = 0; i < s.length; i++)
            a[i] = Integer.parseInt(s[i]);
        return a;
    }

    static char[][] readArrayString() throws IOException {
        String s[] = br.readLine().split(" ");
        char a[][] = new char[s.length][];
        for (int i = 0; i < s.length; i++)
            a[i] = s[i].toCharArray();
        return a;
    }

/*
    Arrays.sort(a, (char[] p1, char[] p2) -> {
                if (p1.length != p2.length)
                    return Integer.compare(p1.length, p2.length);
                return p1.toString().compareTo(p2.toString());
        });



    //Collections.sort(odd);


 for (Map.Entry<Integer, Integer> e: b.entrySet()) {
            int k = e.getKey();
            int v = e.getValue();

        }*/

}

