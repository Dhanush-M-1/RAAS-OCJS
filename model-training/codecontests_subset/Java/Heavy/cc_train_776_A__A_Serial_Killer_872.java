
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer tk = new StringTokenizer(input.readLine());
        String s1 = tk.nextToken();
        System.out.print(s1 + " ");
        String s2 = tk.nextToken();
        System.out.println(s2);
        tk = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(tk.nextToken());
        for (int i = 0; i < n; i++) {
            tk = new StringTokenizer(input.readLine());
            String s3 = tk.nextToken();
            String s4 = tk.nextToken();
            if (s3.equals(s1)) {
                s1 = s4;
            } else if (s3.equals(s2)) {
                s2 = s4;
            }
            System.out.print(s1 + " ");
            System.out.println(s2);

        }
    }

}
