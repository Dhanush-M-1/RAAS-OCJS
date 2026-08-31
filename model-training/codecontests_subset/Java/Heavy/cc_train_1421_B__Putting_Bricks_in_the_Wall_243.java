import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Task2 {

    public static void main(String[] args) throws IOException {
        new Task2().solve();
    }

    private void solve() throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(f.readLine());
        for (int t1 =0; t1 < t; t1++) {
            int n = Integer.parseInt(f.readLine());
            char[][] map = new char[n][n];
            for (int i = 0; i < n; i++) map[i] = f.readLine().toCharArray();
            int[] freq = {0, 0};

            freq[map[0][1] - '0']++;
            freq[map[1][0] - '0']++;
            char down = '0';
            if (map[0][1] == map[1][0]) {
                down = map[0][1];
            } else if (map[n - 1][n -2 ] == map[n - 2][n - 1]) {
                if (map[n - 1][n - 2] == '0') down = '1';
            }
            char up = '1';
            if (down == '1') up = '0';
            ArrayList<int[]> coords = new ArrayList<int[]>();
            if (map[0][1] != down) {
                int[] coord = {1, 2};
                coords.add(coord);
            }
            if (map[1][0] != down)  {
                int[] coord = {2, 1};
                coords.add(coord);
            }
            if (map[n - 1][n - 2] != up) {
                int[] coord = {n, n - 1};
                coords.add(coord);
            }
            if (map[n - 2][n - 1] != up) {
                int[] coord = {n - 1, n};
                coords.add(coord);
            }

            out.println(coords.size());
            for (int[] coord : coords) {
                out.println(coord[0] + " " + coord[1]);
            }
        }

        out.close();
    }
}
