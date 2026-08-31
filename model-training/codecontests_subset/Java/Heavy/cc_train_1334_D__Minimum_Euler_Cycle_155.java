// package codeforces; /Users/attilaj/IdeaProjects/Codejam/src/codeforces/D1334.java

import java.util.Scanner;

public class D1334 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tt = Integer.parseInt(sc.nextLine());
        for (int t = 1; t <= tt; t++) {
            String[] line = sc.nextLine().split(" ");
            int n = Integer.parseInt(line[0]);
            long l = Long.parseLong(line[1]);
            long r = Long.parseLong(line[2]);

            StringBuilder sb = new StringBuilder();
            fill2(sb, n, 1, l - 1, r - 1);
            System.out.println(sb.toString().substring(1));
        }
    }

    private static boolean fill(StringBuilder sb, int n, int add, long l, long r) {
        if (r < 0) {
            return true;
        } else if (n == 1) {
            sb.append(' ').append(1);
            return true;
        } else if (l >= (n - 1) * 2) {
            return fill(sb, n - 1, add + 1, l - (n - 1) * 2, r - (n - 1) * 2);
        } else if (l < (n - 1) * 2) {
            if (l % 2 == 1) {
                sb.append(' ').append((l + 3) / 2 + add - 1);
                l++;
            }
            long ll = l;
            for (long i = l / 2; i <= r / 2 && i < n - 1; i++) {
                sb.append(' ').append(add);
                ll++;
                if (i * 2 + 1 <= r) {
                    sb.append(' ').append(i + add + 1);
                    ll++;
                }
            }
            l = ll;
            return fill(sb, n - 1, add + 1, 0, r - l);
        } else {
            throw new IllegalStateException("??");
        }
    }

    private static void fill2(StringBuilder sb, int n, int add, long l, long r) {
        while (r >= 0) {
            if (n == 1) {
                sb.append(' ').append(1);
                break;
            } else if (l >= (n - 1) * 2) {
                add++;
                l -= (n - 1) * 2;
                r -= (n - 1) * 2;
                n--;
            } else {
                if (l % 2 == 1) {
                    sb.append(' ').append((l + 3) / 2 + add - 1);
                    l++;
                }
                long ll = l;
                for (long i = l / 2; i <= r / 2 && i < n - 1; i++) {
                    sb.append(' ').append(add);
                    ll++;
                    if (i * 2 + 1 <= r) {
                        sb.append(' ').append(i + add + 1);
                        ll++;
                    }
                }
                n--;
                add++;
                r -= ll;
                l = 0;
            }
        }
    }
}

// n*(n-1)+1
// 2-->3
// 3-->7
// 4-->13
// 5-->21

// 1 2 1 3            2 3                             1    4+2+1
// 1 2 1 3 1 4        2 3 2 4         3 4             1    6+4+2+1
// 1 2 1 3 1 4 1 5    2 3 2 4 2 5     3 4 3 5   4 5   1    8+6+4+2+1
// (n-1)*2  (n-2)*2


// 1  2
// 3  4
