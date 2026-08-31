import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class C500 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int weight[] = new int[n + 1];
        int pos[] = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            weight[i] = in.nextInt();
        }

        int[] read = new int[n + 1];
        int index = 1;
        List<Integer> list = new ArrayList<Integer>();
        int[] days = new int[m];
        for (int i = 0; i < m; ++i) {
            int b = in.nextInt();
            days[i] = b;
            if (read[b] == 0) {
                read[b] = index++;
                list.add(b);
            }
        }
        int size = list.size();
        Stack<Integer> stack = new Stack<>();
        for (int i = size - 1; i >= 0; --i) {
            stack.push(list.get(i));
        }

        long total = 0;
        Stack<Integer> temp = new Stack<>();
        for (int i = 0; i < m; ++i) {
            while (true) {
                int book = stack.pop();
                if (book == days[i]) {
                    break;
                }
                total += weight[book];
                temp.add(book);
            }
            while (!temp.empty()) {
                stack.add(temp.pop());
            }
            stack.add(days[i]);
        }
        System.out.println(total);
    }
}
