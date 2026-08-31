import java.util.Scanner;

/**
 * Created by mostafa on 6/7/17.
 */
public class Zgu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        String c = sc.nextLine();


        int[] occa = new int[26];
        int[] occb = new int[26];
        int[] occc = new int[26];

        for(int i = 0; i < a.length(); i++)
            occa[a.charAt(i) - 'a']++;

        for(int i = 0; i < b.length(); i++)
            occb[b.charAt(i) - 'a']++;

        for(int i = 0; i < c.length(); i++)
            occc[c.charAt(i) - 'a']++;

        int maxB = 0, maxC = 0;
        for(int bs = 0; ; bs++) {
            if(can(bs, occa, occb)) {
                int cs = getCs(bs, occa, occb, occc);
                if(bs + cs > maxB + maxC) {
                    maxB = bs; maxC = cs;
                }
            }
            else
                break;
        }

        StringBuilder res = new StringBuilder();
        for(int i = 0; i < maxB; i++)
            res.append(b);
        for(int i = 0; i < maxC; i++)
            res.append(c);

        dec(maxB, occa, occb);
        dec(maxC, occa, occc);

        for(int i = 0; i < 26; i++)
            while(occa[i]-- > 0)
                res.append((char)(i + 'a'));

        System.out.println(res);
    }

    static int getCs(int bs, int[] occa, int[] occb, int[] occc) {
        int cs = (int) 1e7;
        for(int i = 0; i < 26; i++) {
            int rem = occa[i] - occb[i] * bs;
            if(occc[i] > 0)
                cs = Math.min(cs, rem / occc[i]);
        }

        return cs;
    }

    static boolean can(int bs, int[] occa, int[] occb) {
        for(int i = 0; i < 26; i++)
            if(occa[i] < (long) bs * occb[i])
                return false;
        return true;
    }


    static void dec(int taken, int[] occa, int[] occr) {
        for(int i = 0; i < 26; i++)
            occa[i] -= occr[i] * taken;
    }

}
