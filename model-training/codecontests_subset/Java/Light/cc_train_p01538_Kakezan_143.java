

import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    static ArrayList<Integer> multipliedMaxNums;
    static int numOfExe;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            String num = sc.next();
            multipliedMaxNums = new ArrayList<Integer>();
            numOfExe = 0;
            solve(num);
            System.out.println(numOfExe);
        }
        sc.close();
    }

    public static void solve(String num) {
        if (num.length() == 1) {
            // System.out.println(0);
        } else {
            secondExe(num);
        }
    }

    public static void secondExe(String num) {
        int digitNumber = num.length();
        int max = 0;
        for (int i = 0; i < digitNumber - 1; i++) {
            int multipledNum = Integer.parseInt(num.substring(0, (i + 1)))
                    * Integer.parseInt(num.substring((i + 1), digitNumber));
            if (max < multipledNum) {
                max = multipledNum;
            }
        }
        if (multipliedMaxNums.contains(max)) {
            numOfExe = -1;
        } else {
            numOfExe++;
            // System.out.println("?????§??????" + max);
            multipliedMaxNums.add(max);
            solve(String.valueOf(max));
        }
    }

}

// ???????????±????????? 3 9 99 123
// ???????????±????????? 2 999999 1000000
// ???????????±????????? 5 9 99 123 999999 1000000
// 0 2 3 12 1