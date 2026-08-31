
import java.util.*;
import java.io.*;

public class A {

    static StreamTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        int c = ri();
        int v0 = ri();
        int v1 = ri();
        int a = ri();
        int l = ri();
        int days = 1;
        int f = a;
        c -= v0;
        while (c > 0) {
            ++days;
            int read = v0 + f - l;
            c -= (read < v1 - l) ? read : v1 - l;
            f += a;
        }
        System.out.println(days);
    }

    static int ri() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }
}
