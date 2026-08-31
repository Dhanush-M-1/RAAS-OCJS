import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String b = in.nextLine();
        String c = in.nextLine();
        Map<Character, Integer> ac = new HashMap<Character, Integer>();
        Map<Character, Integer> bc = new HashMap<Character, Integer>();
        Map<Character, Integer> cc = new HashMap<Character, Integer>();
        for (Character ch : a.toCharArray())
            ac.put(ch, ac.getOrDefault(ch, 0) + 1);
        for (Character ch : b.toCharArray())
            bc.put(ch, bc.getOrDefault(ch, 0) + 1);
        for (Character ch : c.toCharArray())
            cc.put(ch, cc.getOrDefault(ch, 0) + 1);
        int bCount = Integer.MAX_VALUE;
        for (Character ch : bc.keySet())
            bCount = Math.min(ac.getOrDefault(ch, 0) / bc.get(ch), bCount);
        int cCount = Integer.MAX_VALUE;
        for (Character ch : cc.keySet())
            cCount = Math.min(ac.getOrDefault(ch, 0) / cc.get(ch), cCount);

        if (bCount > cCount) {
            String t = b;
            b = c;
            c = t;
            Map<Character, Integer> tt = bc;
            bc = cc;
            cc = tt;
            int ttt = bCount;
            bCount = cCount;
            cCount = ttt;
        }

        int bMax = 0;
        int cMax = 0;
        for (int i = 0; i <= bCount; i++) {
            int ccCount = Integer.MAX_VALUE;
            for (Character ch : cc.keySet())
                ccCount = Math.min((ac.getOrDefault(ch, 0) - i * bc.getOrDefault(ch, 0)) / cc.get(ch), ccCount);
            if (i + ccCount > bMax + cMax) {
                bMax = i;
                cMax = ccCount;
            }
        }
        for (Character ch : bc.keySet()) {
            if (ac.containsKey(ch))
                ac.put(ch, ac.get(ch) - bc.get(ch) * bMax);
        }

        for (Character ch : cc.keySet()) {
            if (ac.containsKey(ch))
                ac.put(ch, ac.get(ch) - cc.get(ch) * cMax);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bMax; i++)
            sb.append(b);
        for (Character ch: ac.keySet())
            for (int i = 0; i < ac.getOrDefault(ch, 0); i++)
                sb.append(ch);
        for (int i = 0; i < cMax; i++)
            sb.append(c);

        System.out.println(sb.toString());
    }
}