import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        new Solver().run(1);
    }
}

class Solver {

    private BufferedReader reader = null;
    private StringTokenizer st = null;

    private int n, r;
    private long[] data;
    private long sum;

    public void run(int inputType) throws Exception {
        if (inputType == 0)
            reader = new BufferedReader(new FileReader("input.txt"));
        else
            reader = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        sum = 0L;

        data = new long[(1 << n)];
        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < (1 << n); ++i) {
            data[i] = Long.parseLong(st.nextToken());
            sum += data[i];
        }

        System.out.println((sum * 1.0) / (1 << n));

        for (int i = 0; i < r; ++i) {
            st = new StringTokenizer(reader.readLine());
            int indx = Integer.parseInt(st.nextToken());
            long value = Long.parseLong(st.nextToken());

            sum -= data[indx];
            sum += value;
            data[indx] = value;

            System.out.println((sum * 1.0) / (1 << n));
        }

        reader.close();
    }
}
