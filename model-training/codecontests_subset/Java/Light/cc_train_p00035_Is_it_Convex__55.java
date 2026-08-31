import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int MAX_INF = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String line;
        double xa, ya, xb, yb, xc, yc, xd, yd;
        while ((line = in.readLine()) != null) {
            st = new StringTokenizer(line, ",");
            xa = Double.parseDouble(st.nextToken());
            ya = Double.parseDouble(st.nextToken());
            xb = Double.parseDouble(st.nextToken());
            yb = Double.parseDouble(st.nextToken());
            xc = Double.parseDouble(st.nextToken());
            yc = Double.parseDouble(st.nextToken());
            xd = Double.parseDouble(st.nextToken());
            yd = Double.parseDouble(st.nextToken());
            
            double x1 = xb - xa, y1 = yb - ya,
            x2 = xc - xb, y2 = yc - yb, 
            x3 = xd - xc, y3 = yd - yc,
            x4 = xa - xd, y4 = ya - yd;
            
            xa = x1 * y2 - x2 * y1;
            xb = x2 * y3 - x3 * y2;
            xc = x3 * y4 - x4 * y3;
            xd = x4 * y1 - x1 * y4;
            
            if (xa * xb > 0 && xb * xc > 0 && xc * xd > 0 && xa * xd > 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
