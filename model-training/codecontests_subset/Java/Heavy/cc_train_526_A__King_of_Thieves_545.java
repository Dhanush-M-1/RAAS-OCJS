import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by shambala on 04.04.15.
 */
public class TaskA {
    public static void main(String[] args) throws IOException {
        new TaskA().run();
    }

    public void run() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String s =in.readLine();
        for (int i = 0; i<n-3;i++) {
            for (int j = 1; i+4*j<n; j++) {
                if (s.charAt(i)=='*' && s.charAt(i+j)=='*' && s.charAt(i+2*j)=='*' && s.charAt(i+3*j)=='*' && s.charAt(i+4*j)=='*') {
                    System.out.println("yes");
                    return;
                }
            }
        }
        System.out.print("no");
    }
}
