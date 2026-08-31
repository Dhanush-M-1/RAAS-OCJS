//package Coding;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class CodeForces {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        String[] line = in.nextLine().split("\\s+");
        int k = Integer.parseInt(line[0]);
        String word = in.nextLine();
        String res = "";
        boolean isK = true;
        Map<Character, Integer> occur = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            occur.merge(word.charAt(i), 1, Integer::sum);
        }

        for (Character c : occur.keySet()) {
            if (occur.get(c) < k || occur.get(c) % k != 0) {
                isK = false;
                break;
            }
        }

        for (Character c : occur.keySet()) {
            for (int i = 0; i < occur.get(c) / k; i++) {
                res += c;
            }
        }

        if (isK) {
            for (int i = 0; i < k; i++) {
                System.out.print(res);
            }
        } else {
            System.out.println("-1");
        }

    }
}






