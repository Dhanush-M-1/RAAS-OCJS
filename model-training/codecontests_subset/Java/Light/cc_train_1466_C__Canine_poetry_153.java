import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CaninePoetry {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            char [] s = buffer.readLine().toCharArray();
            boolean [] marked = new boolean[s.length];
            for (int i = 1; i < s.length; i++) {
                if (s[i] == s[i-1] && !marked[i-1])
                    marked[i] = true;
                else if (i-2>=0 && s[i-2] == s[i] && !marked[i-2])
                    marked[i] = true;
            }
            int cnt = 0;
            for (boolean check : marked) {
                if (check)
                    cnt++;
            }
            sb.append(cnt+"\n");
        }
        System.out.println(sb);
    }
}
