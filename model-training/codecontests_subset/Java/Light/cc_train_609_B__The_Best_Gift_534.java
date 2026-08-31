import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {
    public static void main(String[] args) throws IOException {
        File inputFile = new File("entradaB");
        if (inputFile.exists())
            System.setIn(new FileInputStream(inputFile));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringBuilder out = new StringBuilder();
        while ((line = in.readLine()) != null) {
            int[] nm = readInts(line);
            int n = nm[0], m = nm[1];
            int[] count = new int[11];
            int[] sum = new int[11];
            int[] v = readInts(in.readLine());
            for (int i = 0; i < n; i++)
                count[v[i]]++;
            sum[10] = count[10];
            for (int i = 9; i >= 0; i--)
                sum[i] = sum[i + 1] + count[i];
            long ans = 0;
            for (int i = 0; i < 10; i++)
                ans += count[i] * sum[i + 1];
            out.append(ans + "\n");
        }
        System.out.print(out);
    }

    public static int[] readInts(String line) {
        String[] w = line.trim().split("\\s+");
        int[] a = new int[w.length];
        for (int i = 0; i < a.length; i++)
            a[i] = Integer.parseInt(w[i]);
        return a;
    }
}
