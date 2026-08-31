import java.util.*;

public class CF {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int i, j, len, where = 0, how_much = 0;
        boolean flag = false;
        StringBuffer strBuf = new StringBuffer(cin.nextLine());
        len = strBuf.length();
        int[] mas = new int[len + 1];

        for (i = 0; i < len; i++) {
            if (strBuf.charAt(i) == '#') {
                strBuf.setCharAt(i, ')');
                where = i;
                how_much++;
            }
        }

        if (strBuf.charAt(0) == '(' && strBuf.charAt(len-1)!='(') {
            mas[0] = 1;
        } else {
            System.out.print("-1");
            System.exit(0);
        }

        for (i = 1; i < len; i++) {
            if (strBuf.charAt(i) == '(') {
                mas[i] = mas[i - 1] + 1;
            } else {
                mas[i] = mas[i - 1] - 1;
            }

            if (mas[i] < 0) {
                System.out.println("-1");
                System.exit(0);
            }
        }

        j = mas[len - 1];
        if(mas[where] < j)
        {
            System.out.println(-1);
            System.exit(0);
        }
        for (i = 1; i < how_much; i++) {
            System.out.println("1");
        }
        System.out.println(1 + j);
    }
}