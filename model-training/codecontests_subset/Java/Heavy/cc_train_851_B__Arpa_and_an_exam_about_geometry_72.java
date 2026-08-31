import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by dell on 2017/9/5.
 */
public class B {

    public static long sqr(long x) {
        return x*x;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        long[][] pt = new long[3][2];
        for (int i=0;i<3;i++) {
            pt[i][0] = Long.parseLong(st.nextToken());
            pt[i][1] = Long.parseLong(st.nextToken());
        }

        double k1, k2;
        long dis1, dis2;
        if (pt[0][0] == pt[1][0])   k1 = 1L<<60;
        else    k1 = (pt[0][1] - pt[1][1]) * 1.0 / (pt[0][0] - pt[1][0]);

        if (pt[1][0] == pt[2][0])   k2 = 1L<<60;
        else    k2 = (pt[1][1] - pt[2][1]) * 1.0 / (pt[1][0] - pt[2][0]);

        dis1 = sqr(pt[0][0]-pt[1][0]) + sqr(pt[0][1]-pt[1][1]);
        dis2 = sqr(pt[1][0]-pt[2][0]) + sqr(pt[1][1]-pt[2][1]);

        if (k1 == k2 || dis1 != dis2) {
            bw.write("No");
        } else
            bw.write("Yes");

        bw.flush();
        bw.close();

    }
}