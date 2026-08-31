import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static String[] chr = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j" };
    static Queue<String> queue = new PriorityQueue<>();

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> list = new ArrayList<>();
        dfs(n, list, 'a');
    }

    static void dfs(int n, List<String> list , char mx) {
        if (list.size() == n) {
            System.out.println(convertListToString(list));
            return;
        }
        for (char c = 'a' ; c <= mx; c++) {
            list.add(String.valueOf(c));
            dfs(n, list, (c == mx ? (char) (mx + 1) : mx));
            list.remove(list.size() - 1);
        }
    }

    static String convertListToString(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String x : list) {
            sb.append(x);
        }
        return sb.toString();
    }

}