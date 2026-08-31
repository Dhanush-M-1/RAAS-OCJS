import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeforcesA {
    public static void main(String[] args)
        throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(reader.readLine());
        String str = reader.readLine();
        for (int i = 0; i < length - 1; i++) {
            if (str.charAt(i + 1) < str.charAt(i)) {
                System.out.println("YES");
                System.out.println(++i + " " + ++i);
                return;
            }
        }
        System.out.println("NO");
    }
}