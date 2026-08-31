import java.io.*;

/**
 * Created by ahmed on 2/13/2016.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] fline = input.readLine().split(" ");
        int n = Integer.parseInt(fline[0]);
        int c = Integer.parseInt(fline[1]);
        String[] xis = input.readLine().split(" ");
        int [] xi = new int[n];
        int ans = 0;
        for(int i = 0 ; i < xi.length - 1 ; i++) {
            ans = Math.max(ans, Integer.parseInt(xis[i]) - c - Integer.parseInt(xis[i + 1]));
        }
        out.write("" + ans);
        out.flush();
    }
}
