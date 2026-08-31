
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.next());
        scan.close();

        Deque<String> queue = new ArrayDeque<String>();

        queue.add("a");

        while (queue.getFirst().length() < n) {
            String str = queue.poll();

            char[] charArray = str.toCharArray();
            char max = 'a';
            for (char c : charArray) {
                if (max < c) {
                    max = c;
                }
            }

            for (char c = 'a'; c <= max + 1; c++) {
                queue.add(str + c);
            }

        }

        for (String s : queue) {
            System.out.println(s);
        }
    }

}
