import java.util.Arrays;
import java.util.Scanner;

public class Main{

    public static void print(Object... o) {
        System.out.println(Arrays.deepToString(o).replaceAll("],", "]\n"));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int d = in.nextInt();
        int f = in.nextInt();
        int[] day = new int[d];

        for (int i = 0; i < day.length; i++) {
            day[i] = in.nextInt();
        }
        int bn = 0;
        for (int j = 0; j < day.length - 1; j++) {
//            bn = (day[j] - day[j+1]) - f > bn ? (day[j] - day[j+1]) - f : bn;
            bn = Math.max((day[j] - day[j+1]) - f, bn);
        }

        System.out.println(bn);
    }
}