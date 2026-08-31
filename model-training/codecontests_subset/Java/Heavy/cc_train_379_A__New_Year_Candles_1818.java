import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by G.Gekko on 27.06.2014.
 */
public class Main {
    public static void main(String[] args) throws IOException {

        TaskA solver = new TaskA();
        solver.solve();

    }
}

class TaskA {
    public void solve() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s = reader.readLine();
        String[] arrStr = s.split("\\s+");
        int a = Integer.parseInt(arrStr[0]);
        int b = Integer.parseInt(arrStr[1]);

        int ans = 0;
        int modulo = 0;
        while (a != 0)
        {
            ans += a;

            modulo += a % b;
            a = a / b + modulo / b;
            modulo %= b;
        }

        System.out.print(ans);
    }
}









