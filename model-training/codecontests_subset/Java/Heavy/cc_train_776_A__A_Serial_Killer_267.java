import java.io.*;
import java.util.*;

public class Main {

    public static int ReadInt(BufferedReader in) throws IOException {
        return Integer.parseInt(in.readLine());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        OutputStream out = new BufferedOutputStream(System.out);
        String[] s = in.readLine().split(" ");
        String first = s[0];
        String second  = s[1];
        int n = ReadInt(in);
        out.write((first + " " + second + "\n").getBytes());
        for (int i = 0; i < n; ++i) {
            s = in.readLine().split(" ");
            if (first.equals(s[0]))
                first = s[1];
            if (second.equals(s[0]))
                second = s[1];
            out.write((first + " " + second + "\n").getBytes());
        }
        out.flush();
    }
}
