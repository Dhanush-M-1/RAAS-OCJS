import java.io.*;
import java.util.*;

public class Example {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer writer = new StringBuffer();
        int t = Integer.parseInt(reader.readLine());
        while (t-- > 0) {
            String[] line = reader.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            int c = Integer.parseInt(line[2]);
            int r = solve(a, b, c);
            writer.append(r);
            writer.append('\n');
        }
        System.out.print(writer);
        reader.close();
    }

    public static int solve(int a, int b, int c) {
        int n1 = Math.min(b, c / 2);
        n1 += Math.min(a, (b - n1) / 2);
        int n2 = Math.min(a, b / 2);
        n2 += Math.min(b - 2 * n2, c / 2);
        return 3 * Math.max(n1, n2);
    }
}
