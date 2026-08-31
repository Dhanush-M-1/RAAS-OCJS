import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class C {

    public static void main(String[] args) {
        InputScanner is = new InputScanner();
        try {
            int n, m;
            n = is.nextInt();
            m = is.nextInt();
            int[] weight = new int[n];
            int[] books = new int[m];
            for (int i = 0; i < n; i++) weight[i] = is.nextInt();
            for (int i = 0; i < m; i++) books[i] = is.nextInt();

            Stack<Integer> stack = new Stack<>();
            Set<Integer> set = new HashSet<>();

            for (int i = 0; i < m; i++) {
                int book = books[i];
                if (!set.contains(book)) {
                    set.add(book);
                    stack.push(book);
                }
            }

            Stack<Integer> reversedStack = new Stack<>();
            Stack<Integer> tmpStack = new Stack<>();

            while(!stack.isEmpty())
                reversedStack.push(stack.pop());

            int result = 0;
            for (int i = 0; i < m; i++){
                int bookNr = books[i];
                while(reversedStack.peek()!=bookNr){
                    tmpStack.push(reversedStack.pop());
                    result += weight[tmpStack.peek()-1];
                }
                int b = reversedStack.pop();
                while(!tmpStack.isEmpty()){
                    reversedStack.push(tmpStack.pop());
                }
                reversedStack.push(b);
            }
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class InputScanner {

        BufferedReader br;
        StringTokenizer st;

        public InputScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() throws IOException {
            if (st == null || !st.hasMoreTokens()) {
                String line = br.readLine();
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            String next = next();
            return Integer.parseInt(next);
        }

        public long nextLong() throws IOException {
            String next = next();
            return Long.parseLong(next);
        }
    }
}
