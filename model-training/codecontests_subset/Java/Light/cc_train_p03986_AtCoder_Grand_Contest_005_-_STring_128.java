import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        int ans = solve(s);
        System.out.println(ans);
    }

    static int solve(String s) {
        char[] c = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        int remainT = 0;
        for (int i = 0; i < s.length(); i++) {
            if (c[i] == 'S') {
                stack.add(c[i]);
            } else {
                if (!stack.isEmpty() && stack.peek() == 'S') {
                    stack.pop();
                } else {
                    remainT++;
                }
            }
        }
        return stack.size() + remainT;
    }
}
