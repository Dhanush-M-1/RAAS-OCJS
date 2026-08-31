import java.io.*;
import java.util.*;

public class Solution {

    StreamTokenizer in;
    PrintWriter out;

    public static void main(String[] args) throws Exception {
        new Solution().run();
    }

    int nextInt() throws Exception {
        in.nextToken();
        return (int) in.nval;
    }

    public void run() throws Exception {
        in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int n =nextInt();
        for (int i=1; i<n; ++i) {
            for (int j=1; j<n; ++j)
                out.print(Integer.toString(i*j,n)+" ");
            out.println();
        }
        out.flush();
    }

}
