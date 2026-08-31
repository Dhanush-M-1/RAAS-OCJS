import java.io.*;

public class P50 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws IOException {
        String[] split = br.readLine().split(" ");
        int a = Integer.parseInt(split[0]);
        int b = Integer.parseInt(split[1]);

        int total = 0;
        int curr = a;
        while(curr >= b) {
            int newCandles = curr/b;
            total += newCandles*b;
            curr += newCandles - newCandles*b;
        }
        total += curr;
        pw.println(total);

        pw.close();
    }
} 