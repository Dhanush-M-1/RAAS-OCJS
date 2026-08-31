import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str1 = br.readLine();
        StringTokenizer st = new StringTokenizer(str1, " ");
        int r1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        String str2 = br.readLine();
        st = new StringTokenizer(str2, " ");
        int c1 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());
        String str3 = br.readLine();
        st = new StringTokenizer(str3, " ");
        int d1 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());
        if (r1 + r2 == c1 + c2 && c1 + c2 == d1 + d2) {
            int a = (r1 + c1 - d2) / 2;
            int b = (d2 - c1 + r1) / 2;
            int c = (d2 + c1 - r1) / 2;
            int d = (2 * c2 + c1 - d2 - r1) / 2;
            if (a != b && b != c && c != d && a != c && a != d && b != d && (a>=1 && a<10) && (b>=1 && b<10) && (c>=1 && c<10) && (d>=1 && d<10)) {
                if (d1 == a + d && d2 == b + c && r1 == a + b && r2 == c + d && c1 == a + c && c2 == b + d) {
                    bw.write(a + " " + b + "\n" + c + " " + d + "\n");
                } else {
                    bw.write(-1 + "\n");
                }
            } else {
                bw.write(-1 + "\n");
            }
        } else {
            bw.write(-1 + "\n");
        }
        bw.flush();
    }
}
