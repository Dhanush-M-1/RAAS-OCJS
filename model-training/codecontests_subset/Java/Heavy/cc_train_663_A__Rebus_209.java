

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] strings = s.split(" ");
        int posCount = 1;
        int negCount = 0;
        for (String str : strings) {
            if (str.equals("+")) {
                posCount++;
            }
            else if (str.equals("-")) {
                negCount++;
            }
        }
        int target = Integer.parseInt(strings[strings.length - 1]);
        int max = posCount * target - negCount;
        int min = posCount - negCount * target;
        if (min <= target && max >= target) {
            System.out.println("Possible");
            int posTarget = posCount;
            int negTarget = 0;
            boolean failed = false;
            int[] pos = new int[posCount];
            int[] neg = new int[negCount];
            Arrays.fill(neg, 1);
            if (posCount > target) {
                negTarget = (posCount - target);
                Arrays.fill(pos, 1);
                for (int i = 0; i < negCount; i++) {
                    int remaining = negTarget - negCount + i + 1;
                    if (remaining > 0) {
                        neg[i] = Math.min(remaining, target);
                    }
                    else {
                        neg[i] = 1;
                    }
                    negTarget -= neg[i];
                }
                if (negTarget < 0) {
                    failed = true;
                }
            }
            if (posCount > 0 || failed) {
                if (failed) {
                    posTarget = posCount + Math.abs(negTarget);
                }
                else {
                    posTarget = target + negCount;
                }
                for (int i = 0; i < posCount; i++) {
                    int remaining = posTarget - posCount + i + 1;
                    if (remaining > 0) {
                        pos[i] = Math.min(remaining, target);
                    }
                    else {
                        pos[i] = 1;
                    }
                    posTarget -= pos[i];
                }
            }
            int posIndex = 0;
            int negIndex = 0;
            StringBuffer sb = new StringBuffer();
            boolean pastPos = true;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '?') {
                    if (pastPos) {
                        sb.append(pos[posIndex++]);
                    }
                    else {
                        sb.append(neg[negIndex++]);
                    }
                    continue;
                }
                if (s.charAt(i) == '+') {
                    pastPos = true;
                }
                if (s.charAt(i) == '-') {
                    pastPos = false;
                }
                sb.append(s.charAt(i));
            }
            System.out.println(sb.toString());
        }
        else {
            System.out.println("Impossible");
        }
    }
}
