import java.util.*;

public class GFG {
    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t-- > 0) {
            int n = s.nextInt();
            char arr[][] = new char[n][n];
            for (int i = 0; i < n; i++) {
                String data = s.next();
                for (int j = 0; j < n; j++)
                    arr[i][j] = data.charAt(j);
            }
            ArrayList<Pair> list = new ArrayList<>();
            int a = arr[0][1] - '0';
            int b = arr[1][0] - '0';
            int c = arr[n - 1][n - 2] - '0';
            int d = arr[n - 2][n - 1] - '0';
            if (a == b) {
                if (a == 1) {
                    if (c == 1)
                        list.add(new Pair(n, n - 1));
                    if (d == 1)
                        list.add(new Pair(n - 1, n));
                } else {
                    if (c == 0)
                        list.add(new Pair(n, n - 1));
                    if (d == 0)
                        list.add(new Pair(n - 1, n));
                }
            } else if (c == d) {
                if (c == 1) {
                    if (a == 1)
                        list.add(new Pair(1, 2));
                    if (b == 1)
                        list.add(new Pair(2, 1));
                } else {
                    if (a == 0)
                        list.add(new Pair(1, 2));
                    if (b == 0)
                        list.add(new Pair(2, 1));
                }
            } else {
                if (a == 1)
                    list.add(new Pair(1, 2));
                if (b == 1)
                    list.add(new Pair(2, 1));

                if (c == 0)
                    list.add(new Pair(n, n - 1));
                if (d == 0)
                    list.add(new Pair(n - 1, n));
            }

            System.out.println(list.size());
            for (Pair p : list) {
                System.out.println(p.x + " " + p.y);
            }
        }
        s.close();
    }
}