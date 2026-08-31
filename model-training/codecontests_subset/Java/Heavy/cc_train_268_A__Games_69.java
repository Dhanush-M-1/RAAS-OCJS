import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Games {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int games = Integer.parseInt(input.readLine());

        int[][] array = new int[100][2];

        for (int i = 0; i < games; i++) {
            String[] n = input.readLine().split("\\s+");
            array[i][0] = Integer.parseInt(n[0]);
            array[i][1] = Integer.parseInt(n[1]);
        }

        System.out.println(CF268D2A(games,array));
    }

    static int CF268D2A(int n, int[][] arr) {
        int r = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((arr[i][0] == arr[j][1]) && (j != i)) {
                    r++;
                }
            }
        }
        return r;
    }
}
