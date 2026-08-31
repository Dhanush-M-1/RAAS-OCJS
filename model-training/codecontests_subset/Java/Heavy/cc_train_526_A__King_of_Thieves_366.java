import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class CR2015A {
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        n = Integer.parseInt(r.readLine());
        char[] cc = r.readLine().trim().toCharArray();
        String result = "no";
        for (int start = 0; start < n; start++) {
            for (int delta = 1; delta <= 35; delta++) {
                boolean isGood = true;
                for (int i = 0; i < 5; i++) {
                    int position = start + i * delta;
                    if (position >= n || cc[position] == '.') {
                        isGood = false;
                    }
                }
                if (isGood) {
                    result = "yes";
                }
            }
        }
        pw.println(result);
        pw.flush();
    }
}
