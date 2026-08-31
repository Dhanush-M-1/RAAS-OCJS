import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArraySharpening {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            List<Integer> nums = new ArrayList<>();
            for (int index = 0; index < N; index++) {
                int a = sc.nextInt();
                nums.add(a);
            }
            int left = 0;
            for (int index = 0; index < N; index++) {
                if (nums.get(index) < index) {
                    break;
                }
                left = index;
            }
            int right = 0;
            for (int index = N - 1; index >= 0; index--) {
                if (nums.get(index) < N - index - 1) {
                    break;
                }
                right = index;
            }
            if (left >= right) {
                out.println("YES");
            } else {
                out.println("NO");
            }
        }
        out.close();

    }

}
