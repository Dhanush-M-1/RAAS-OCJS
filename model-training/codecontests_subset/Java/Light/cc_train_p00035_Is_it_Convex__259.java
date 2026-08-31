import java.util.Arrays;
import java.util.Scanner;

//線分交差判定を使用
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            Double[] list = Arrays.stream(sc.nextLine().split(",")).map(Double::parseDouble).toArray(Double[]::new);
            System.out.println(intersected(list) ? "YES" : "NO");
        }
    }

    static boolean intersected(Double[] list) {
        double ta = (list[0] - list[2]) * (list[5] - list[1]) + (list[1] - list[3]) * (list[0] - list[4]);
        double tb = (list[0] - list[2]) * (list[7] - list[1]) + (list[1] - list[3]) * (list[0] - list[6]);
        double tc = (list[4] - list[6]) * (list[1] - list[5]) + (list[5] - list[7]) * (list[4] - list[0]);
        double td = (list[4] - list[6]) * (list[3] - list[5]) + (list[5] - list[7]) * (list[4] - list[2]);

        return ta * tb > 0 && tc * td > 0;
    }
}
