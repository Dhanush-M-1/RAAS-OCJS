// package educational_round_28;

import java.io.*;

/**
 * Created by nikitos on 13.01.18.
 */
public class A1 {

    public StreamTokenizer t;

    public int nextInt() throws IOException {
        t.nextToken();
        return (int) t.nval;
    }

    public String nextString() throws IOException {
        t.nextToken();
        return t.sval;
    }

    public void start() throws IOException {
        t = new StreamTokenizer( new BufferedReader(new InputStreamReader(System.in)));

        int n = nextInt();
        int k = nextInt();
        int[] inputs = new int[n];
        for (int i = 0; i < n; i++) {
            inputs[i] = nextInt();
        }

        int min = 1000000000;
        int currVed = 0;
        for (int i = 0; i < n; i++) {
            int p = maxDel(inputs[i],k);
            if (p < min && p != 0 && k >= inputs[i]) {
                min = p;
                currVed = i;
            }
        }

        System.out.println(k / inputs[currVed]);
    }

    public int maxDel(int b, int a) {
        return a % b == 0?  a / b: 0;
    }

    public static void main(String[] args) throws IOException {
        new A1().start();
    }

}
