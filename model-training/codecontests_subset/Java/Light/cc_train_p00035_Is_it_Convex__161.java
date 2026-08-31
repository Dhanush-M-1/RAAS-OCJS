import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String[] S = sc.next().split(",");

            double[][] point = new double[4][2];
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 2; j++) {
                    point[i][j] = Double.parseDouble(S[i*2+j]);
                }
            }

            int r = 0;
            for (int i = 0; i < 4; i++) {
                if(((point[(i + 1) % 4][0] - point[i][0]) * (point[(i + 2) % 4][1] - point[(i + 1) % 4][1]) -
                        (point[(i + 1) % 4][1] - point[i][1]) * (point[(i + 2) % 4][0] - point[(i + 1) % 4][0])) > 0) {
                    r += 1;
                } else {
                    r -= 1;
                }
            }

            System.out.println((Math.abs(r) == 4)? "YES" : "NO");
        }
    }
}