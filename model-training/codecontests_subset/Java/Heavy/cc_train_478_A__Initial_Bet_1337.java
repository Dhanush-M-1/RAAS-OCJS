
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class R273D2A {

    private static final String LNSP = System.getProperty("line.separator");

    public static void main(String args[] ) throws Exception {
        StringBuilder cout = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        String[] words;
        int n = 5;
        int sum = 0;
        int[] c = new int[n];
        line = br.readLine();
        words = line.split(" ");
        for (int i = 0; i < n; i++) {
            c[i] = Integer.parseInt(words[i]);
            sum += c[i];
        }

        int ret = 0;
        if (sum % n == 0) {
            ret = sum / 5;
            if (ret == 0) {
                ret = -1;
            }
        } else {
            ret = -1;
        }

        cout.append(ret);
        cout.append(LNSP);
        System.out.print(cout);
    }

}
