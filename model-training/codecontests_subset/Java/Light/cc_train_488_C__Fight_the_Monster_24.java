import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by chinh on 7/19/14.
 */
public class R278D2C {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int hy = Integer.parseInt(st.nextToken());
        int ay = Integer.parseInt(st.nextToken());
        int dy = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int hm = Integer.parseInt(st.nextToken());
        int am = Integer.parseInt(st.nextToken());
        int dm = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int min = Integer.MAX_VALUE;
        for(int dn = dy; dn<=Math.max(dy, am); dn++){
            for(int an = Math.max(dm+1, ay); an<=Math.max(hm+dm, ay); an++){
                int vy = an-dm;
                int vm = am-dn;
                int sm = hm/vy + (hm%vy>0 ? 1 : 0);
                int hn = Math.max(hy, sm*vm+1);
                min = Math.min(min, (dn-dy)*d+(an-ay)*a+(hn-hy)*h);
            }
        }
        System.out.println(min);
    }
}
