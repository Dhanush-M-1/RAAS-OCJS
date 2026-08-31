import java.util.Scanner;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        // BEGIN initialize singles array
        int[] temp = new int[3];
        temp[0] = 0;
        temp[1] = 4;
        temp[2] = 7;
        HashMap<Integer, ArrayList<Integer>> singles = new HashMap<Integer, ArrayList<Integer>>();
        

        for (int i = 0; i < 43; i++) {
            if (!singles.containsKey(i)) {
                for (int j = 0; j < 3; j++) {
                    if (!singles.containsKey(i)) {
                        for (int k = j; k < 3; k++) {
                            if (!singles.containsKey(i)) {
                                for (int l = k; l < 3; l++) {
                                    if (!singles.containsKey(i)) {
                                        for (int m = l; m < 3; m++) {
                                            if (!singles.containsKey(i)) {
                                                for (int n = m; n < 3; n++) {
                                                    if (!singles.containsKey(i)) {
                                                        for (int o = n; o < 3; o++) {
                                                            if (temp[j]
                                                                    + temp[k]
                                                                    + temp[l]
                                                                    + temp[m]
                                                                    + temp[n]
                                                                    + temp[o] == i) {
                                                                if (!singles
                                                                        .containsKey(i)) {
                                                                    ArrayList tempList = new ArrayList<Integer>();
                                                                    tempList.add(temp[j]);
                                                                    tempList.add(temp[k]);
                                                                    tempList.add(temp[l]);
                                                                    tempList.add(temp[m]);
                                                                    tempList.add(temp[n]);
                                                                    tempList.add(temp[o]);
                                                                    singles.put(
                                                                            i,
                                                                            tempList);
                                                                } else {
                                                                    o = 3;
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        n = 3;
                                                    }
                                                }
                                            } else {
                                                m = 3;
                                            }
                                        }
                                    } else {
                                        l = 3;
                                    }
                                }
                            } else {
                                k = 3;
                            }
                        }
                    } else {
                        j = 3;
                    }
                }
            }
        }
        // END initialize singles array
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            char[] nString = in.next().toCharArray();
            int[] n = new int[nString.length];
            for (int j = 0; j < n.length; j++) {
                n[j] = Character.digit(nString[j], 10);
            }
            ArrayList<Integer> able = new ArrayList<Integer>();
            boolean foundIt = false;
            if (n[0] - 8 <= 4 && n[0] - 8 >= 0) {
                able.add(8);
            }
            if (n[0] - 7 <= 4 && n[0] - 7 >= 0) {
                able.add(7);
            }
            if (n[0] - 4 <= 4 && n[0] - 4 >= 0) {
                able.add(4);
            }
            if (n[0] - 0 <= 4 && n[0] - 0 >= 0) {
                able.add(0);
            }
            if(n.length > 1){
            ArrayList<Integer> answer = new ArrayList<Integer>();
            for (int j = 0; j < able.size(); j++) {
                int tens = n[0] - able.get(j);
                if (!foundIt) {
                    foundIt = f(n, tens, singles, 1, answer);
                    if (foundIt) {
                        answer.add(able.get(j));
                    }
                }
            }
            if (!foundIt) {
                System.out.println(-1);
            } else {
                long[] finalAnswer = new long[6];
                for (int j = 0; j < 6; j++) {
                    for (int k = 0; k < n.length; k++) {
                        finalAnswer[j] += singles.get(answer.get(k)).get(j)
                                * (long)Math.pow(10, k);
                    }
                    System.out.print(finalAnswer[j] + " ");
                }
            }
            }
            else{
                if(!singles.containsKey(n[0])){
                    System.out.println(-1);
                }
                else{
                    for(int j = 0; j < 6; j++){
                        System.out.print(singles.get(n[0]).get(j) + " ");
                    }
                }
            }
        }
    }

    public static boolean f(int[] n, int tens,
            HashMap<Integer, ArrayList<Integer>> singles, int current,
            ArrayList<Integer> answer) {
        boolean foundIt = false;

        if (current + 1 == n.length) {
            int tempNumber = tens * 10 + n[current];
            if (singles.containsKey(tempNumber)) {
                answer.add(tempNumber);
                return true;
            }
            return false;
        }

        ArrayList<Integer> able = new ArrayList<Integer>();
        for (int i = 0; i < 6 && i <= n[current]; i++) {
            int tempNumber = tens * 10 + n[current] - i;
            if (singles.containsKey(tempNumber)) {
                able.add(n[current] - i);
            }
        }
        int singlesDigit = 0;
        for (int i = 0; i < able.size(); i++) {
            if (!foundIt) {
                foundIt = f(n, n[current] - able.get(i), singles, current + 1,
                        answer);
                if (foundIt) {
                    singlesDigit = able.get(i);
                }
            }
        }
        // BEGIN take one and add 10
        if (!foundIt) {
            if (tens > 0) {
                tens -= 1;
                int tempDigit = n[current] + 10;
                able.clear();
                // BEGIN find able again
                for (int i = 0; i < 6 && i <= tempDigit; i++) {
                    if (tempDigit - i < 10) {
                        int tempNumber = tens * 10 + tempDigit - i;
                        if (singles.containsKey(tempNumber)) {
                            able.add(tempDigit - i);
                        }
                    }
                }
                // END find able again
                for (int i = 0; i < able.size(); i++) {
                    if (!foundIt) {
                        foundIt = f(n, tempDigit - able.get(i), singles,
                                current + 1, answer);
                        if (foundIt) {
                            singlesDigit = able.get(i);
                        }
                    }
                }
            }
        }
        // END take one and add 10
        if (foundIt) {
            answer.add(tens * 10 + singlesDigit);
        }
        return foundIt;
    }

}
