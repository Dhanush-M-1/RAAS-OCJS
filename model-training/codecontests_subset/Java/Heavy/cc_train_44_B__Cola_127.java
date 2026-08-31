
import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
    new Solution().run();
    }

StreamTokenizer in;
PrintWriter out;

int nextInt() throws Exception {
    in.nextToken();
    return (int) in.nval;
}

public void run() throws Exception {
    in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    out = new PrintWriter(new OutputStreamWriter(System.out));
    int n = nextInt();
    int a = nextInt();
    int b = nextInt();
    int c = nextInt();
    int k=0;
    for (int i=0;i<=b;i++)
        for (int j=0; j<=c;j++)
            if (((n-i-j*2)*2<=a)&&((n-i-j*2>=0))) k++;
    out.println(k);
    out.flush();
}

}
