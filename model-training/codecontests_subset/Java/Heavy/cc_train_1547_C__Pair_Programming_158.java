import java.io.PrintWriter;
import java.util.Scanner;

public class pairProg {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int t = in.nextInt();

        for(int i = 0; i < t; i++) {
            int lines = in.nextInt();
            int polyLen = in.nextInt();
            int monoLen = in.nextInt();
            int[] poly = new int[polyLen + 1];
            int[] mono = new int[monoLen + 1];
            poly[polyLen] = 1_000;
            mono[monoLen] = 1_000;

            // get data
            for (int j = 0; j < polyLen; j++) {
                poly[j] = in.nextInt();
            }

            for (int j = 0; j < monoLen; j++) {
                mono[j] = in.nextInt();
            }

            int polyPointer = 0;
            int monoPointer = 0;

            boolean broken = false;
            int[] answer = new int[polyLen + monoLen];
            for (int j = 0; j < polyLen + monoLen; j++) {
                if (poly[polyPointer] == 0) {
                    polyPointer++;
                    answer[j] = 0;
                    lines++;
                } else if (mono[monoPointer] == 0) {
                    monoPointer++;
                    answer[j] = 0;
                    lines++;
                } else if (poly[polyPointer] <= lines) {
                    answer[j] = poly[polyPointer];
                    polyPointer++;
                } else if (mono[monoPointer] <= lines) {
                    answer[j] = mono[monoPointer];
                    monoPointer++;
                } else {
                    out.println(-1);
                    broken = true;
                    break;
                }
            }

            if (broken == false) {
                for (int j = 0; j < polyLen + monoLen - 1; j++) {
                    out.printf(answer[j] + " ");
                }
                out.println(answer[polyLen + monoLen - 1]);
            }
        }

        out.close();
    }
}
