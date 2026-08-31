import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.solve();
    }
    public void solve() {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String S = scan.next();
        char[] d = S.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < d.length; i++) {
            if (d[i] == 'S') {
                stack.push(d[i]);
                continue;
            }
            if (stack.empty()) {
                stack.push(d[i]);
                continue;
            }
            char x = stack.peek();
            if (x == 'S') {
                stack.pop();
                continue;
            }
            stack.push(d[i]);
        }
        System.out.println(stack.size());
    }
}
