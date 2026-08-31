import java.util.Scanner;

class Solver {
    public void Solve() {
        String s = sc.next();
        int k = sc.nextInt();
        long len = s.length();
        int first = Integer.parseInt(s.substring(0, 1));
        long ans = 0;
        if (k == 1) {
            ans = solve1(len, s);
        } else if (k == 2) {
            ans = solve2(len, s);
        } else {
            ans = solve3(len, s);
        }
        System.out.println(ans);
        int a = 0;

    }

    public long solve1(long len, String s) {
        // System.out.println(s);
        while (true) {
            if (s.length() == 0) {
                return 0;
            }
            if (s.charAt(0) != '0') {
                break;
            } else {
                s = s.substring(1);
            }
        }
        len = s.length();
        int first = Integer.parseInt(s.substring(0, 1));
        long ans = 0;
        ans += (len - 1) * 9;
        ans += first;
        // System.out.println(ans);
        return ans;
    }

    public long solve2(long len, String s) {
        // System.out.println(s);
        while (true) {
            if (s.length() <= 1) {
                return 0;
            }
            if (s.charAt(0) != '0') {
                break;
            } else {
                s = s.substring(1);
            }
        }
        len = s.length();
        int first = Integer.parseInt(s.substring(0, 1));
        long ans = 0;
        ans += (len - 1) * (len - 2) / 2 * 9 * 9;
        ans += (first - 1) * (len - 1) * 9;
        ans += solve1(len, s.substring(1));
        // System.out.println(ans);
        return ans;
    }

    public long solve3(long len, String s) {
        // System.out.println(s);
        while (true) {
            if (s.length() < 3) {
                return 0;
            }
            if (s.charAt(0) != '0') {
                break;
            } else {
                s = s.substring(1);
            }
        }
        long ans = 0;
        int first = Integer.parseInt(s.substring(0, 1));
        ans += (len - 1) * (len - 2) * (len - 3) / 2 * 3 * 9 * 9;
        ans += (first - 1) * (len - 1) * (len - 2) / 2 * 9 * 9;
        ans += solve2(len, s.substring(1));
        // System.out.println(ans);
        return ans;
        // int next = Integer.parseInt(s.substring(1, 2));
        // if (len == 3) {
        // ans += (first - 1) * 9 * 9;
        // ans += next * 9;
        // System.out.println(ans);
        // return 0;
        // }
        // // 先頭使わない
        // ans += (len - 1) * (len - 2) * (len - 3) / 2 * 3 * 9 * 9;
        // // 先頭使う 最大ではない
        // ans += (first - 1) * (len - 1) * (len - 2) / 2 * 9 * 9;
        // if (next != 0) {
        // // 先頭最大値 2番目最大でない
        // ans += (next - 1) * (len - 2) * 9;
        // }
        // ans += (len - 2) * (len - 3) / 2 * 9 * 9;
        // // ans += (len - 3) * 9;
        // for (int i = 2; i < len; i++) {
        // int a = Integer.parseInt(s.substring(i, i + 1));
        // if (a == 0) {
        // continue;
        // } else {
        // ans += a;
        // ans += (len - 1 - i) * 9;
        // break;
        // }
        // }
        // // 先頭最大 2番目も最大
        // // ans += (third - 1) * (len - 3) * 9;
        // System.out.println(ans);
        // return ans;
    }

    Scanner sc;

    Solver(Scanner in) {
        this.sc = in;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solver s = new Solver(sc);
        s.Solve();
        sc.close();
    }
}
