

import java.util.Scanner;

public class TaskC {
    public static String s;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        s = scan.next();
        int temp = 0;
        int cur = 0;
        int pT=0;
        int[] res = new int[100001];
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '(') {
                temp++;
                pT++;
            }
            else if (s.charAt(i) == ')') {
                temp--;
                pT=pT==0?0:pT-1;
            }
            else {
                res[cur++] = 1;
                temp--;
                pT=0;
            }
            if (temp < 0) {
                System.out.println("-1");
                return;
            }
        }
        if (pT > 0) {
            System.out.println("-1");
            return;
        }
        cur--;
        res[cur++] += temp;
        for (int i=0; i<cur; i++) System.out.println(res[i]);
    }
}
