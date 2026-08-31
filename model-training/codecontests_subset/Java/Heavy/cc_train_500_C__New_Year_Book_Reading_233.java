import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class NewYearReading {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n + 1];
        int[] start = new int[n + 1];
        int[] orders = new int[m + 1];
        boolean[] was = new boolean[n + 1];
        Arrays.fill(was, false);
        int index = 1;
        
        for (int i = 1; i <= n; i++)
            a[i] = in.nextInt();
        for (int i = 1; i <= m; i++) {
            orders[i] = in.nextInt();
            if (!was[orders[i]]) {
                was[orders[i]] = true;
                start[index++] = orders[i];
            }
        }
        
        Stack<Integer> st = new Stack<Integer>();
        for (int i = n; i >= 1; i--)
            st.push(start[i]);
        
        int res = 0;
        for (int i = 1; i <= m; i++) {
            int book = orders[i];
            Stack<Integer> temp = new Stack<Integer>();
            while (!st.isEmpty() && st.peek() != book) {
                res += a[st.peek()];
                temp.push(st.pop());
            }
            int bookWeight = st.pop();
            while (!temp.isEmpty())
                st.push(temp.pop());
            st.push(bookWeight);
        }
        System.out.println(res);
        
    }
}