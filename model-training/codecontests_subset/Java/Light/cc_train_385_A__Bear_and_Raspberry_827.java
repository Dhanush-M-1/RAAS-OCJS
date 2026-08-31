import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class BearandRaspberry {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(in.readLine());
        int prev = Integer.parseInt(st.nextToken());
        int next = 0;
        int res = 0;
        for (int i = 1; i < n; i++) {
            next = Integer.parseInt(st.nextToken());
            if((prev-next-c)>res)
                res = prev - next-c;
            prev = next;
        }
        out.println(res);
        in.close();
        out.close();
    }
}
