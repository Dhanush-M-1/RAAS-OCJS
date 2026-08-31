import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int[] letters = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int ascii = (int) s.charAt(i) - 97;
            letters[ascii]++;
        }

        String str = "";
        for (int i = 0; i < 26; i++) {
            int k = letters[i];
//            System.out.println(k);
            if (k == 0) continue;
            if (k % n == 0) {
                String temp = Character.toString((char) (i + 97));
//                System.out.println(temp);
                for (int l = 0; l < k/n; l++) str+=temp;
                continue;
            } else {
                System.out.println("-1");
                return;
            }
        }

        String done = "";
        for (int i = 0; i < n; i++) {
            done += str;
        }
        System.out.println(done);

    }
}