import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Preform_the_Combo2 {
    public static void main(String args[]) {
        Scanner reader = new Scanner(System.in);

        int t = reader.nextInt();
        ArrayList<int[]> answer = new ArrayList<>(t);

        for (int i = 0; i < t; i++) {
            int[] aList = new int[26];
            int n = reader.nextInt();
            int m = reader.nextInt();
            String s = reader.next();
            ArrayList<Integer> p = new ArrayList<>(m);
            while (m-- > 0)
                p.add(reader.nextInt() - 1);

            Collections.sort(p);

            int counter = 1;
            int j = p.size() - 1;
            while (--n >= 0) {
                while (j != -1 && p.get(j) == n) {
                    counter++;
                    j--;
                }

                aList[s.charAt(n) - 97] += counter;
            }

            answer.add(aList);
        }

        reader.close();

        for (int i = 0; i < t; i++) {
            for (int j = 0; j < 26; j++)
                System.out.print(answer.get(i)[j] + " ");
            System.out.println();
        }
    }
}
