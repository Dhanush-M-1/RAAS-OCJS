import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class B {

    public static void main(String[] args) throws IOException {
        BufferedReader std = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        String s = std.readLine();
        String[] ss = s.split(" ");
        int n = Integer.parseInt(ss[0]);
        int x = Integer.parseInt(ss[1]);
        double y = Double.parseDouble(ss[2]);
        double p = y / 100.0;
        double pp = p * n;
        int r = (int) Math.ceil(pp);
        r -= x;
        if (r < 0) 
            out.println(0);
        else
            out.println(r);
        out.flush();
    }
}
