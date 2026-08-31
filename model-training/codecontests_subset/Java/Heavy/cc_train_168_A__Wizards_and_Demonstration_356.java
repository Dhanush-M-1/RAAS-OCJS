
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A168A {
    public static void main(String[] args) throws IOException {

        A168A a = new A168A();
        a.solve();
    }

    public void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream bos = new BufferedOutputStream(new BufferedOutputStream(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int x = Integer.parseInt(input[1]);
        int p = Integer.parseInt(input[2]);

        int tp = (n * p + 99) / 100 - x;
        if( tp > 0 )
            bos.write(String.valueOf(tp).getBytes());
        else
            bos.write("0".getBytes());

        bos.flush();
    }
}
