/**
 * Created by Aminul on 9/4/2017.
 */

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF851B {
    public static int index;
    public static void main(String[] args)throws Exception {
        InputReader in = new InputReader(System.in);
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        //int n = in.nextInt();
        P a = new P(in.nextDouble(), in.nextDouble());
        P b = new P(in.nextDouble(), in.nextDouble());
        P c = new P(in.nextDouble(), in.nextDouble());

        P center = findCenter(a, b, c);


        if(isNaN(center.x) || isNaN(center.y)) center = findCenter(a, c, b);

    //    debug(center);

        if(isNaN(center.x) || isNaN(center.y)) center = findCenter(b, a, c);

     //   debug(center);

        if(isNaN(center.x) || isNaN(center.y)) center = findCenter(b, c, a);

   //     debug(center);

        if(isNaN(center.x) || isNaN(center.y)) center = findCenter(c, a, b);

      //  debug(center);

        if(isNaN(center.x) || isNaN(center.y)) center = findCenter(c, b, a);

      //  debug(center);
        //debug(center.x, center.y, center.x == 0.0/0.0, isNaN(center.x)) ;


        long d1 = a.distLongSq(b);
        long d2 = b.distLongSq(c);
       // double d3 = c.distSq(a);

        double ang1 = fixAng(getAngle(center, a) - getAngle(center, b));
        double ang2 = fixAng( getAngle(center, b) - getAngle(center, c));

      //  debug(getAngle(center, a), getAngle2(center, a));
      //  debug(getAngle(center, c), getAngle2(center, c));

//        debug(center, d1, d2, ang1, ang2, getAngle(center, a), ang1, ang2, getAngle(center,b), getAngle(center, c));

        if(!isNaN(center.x) && !isNaN(center.y) && Math.abs(d1 - d2) <= EPS && Math.abs(ang1 - ang2) <= EPS ) pw.println("YES");
        else pw.println("NO");


        pw.close();
    }

    static double fixAng(double a){
        if( a < 0){
            return 360+a;
        }
        return a;
    }

    static public boolean isNaN(double v) {
        return (v != v) || v == 1/0.0 || v == 0/0.0;
    }

    static P findCenter(P a, P b, P c){
        P cen = new P(0, 0);
        double XMid1= (a.x + b.x) / 2;
        double XMid2= (a.x + c.x) / 2;

        double YMid1= (a.y + b.y) / 2;
        double YMid2= (a.y + c.y) / 2;

        double Slope1= (a.x - b.x) / (b.y - a.y);
        double Slope2= (a.x - c.x) / (c.y - a.y);

        double Perp1 = YMid1 - (Slope1 * XMid1);
        double Perp2= YMid2 - (Slope2 * XMid2);

        cen.x = (Perp1 - Perp2) / (Slope2 - Slope1);
        cen.y = Perp1 + (Slope1 * cen.x);

        return cen;
    }

    static P circleCenter(P A, P B, P C) {
        double yDelta_a = B.y - A.y;
        double xDelta_a = B.x - A.x;
        double yDelta_b = C.y - B.y;
        double xDelta_b = C.x - B.x;
        P center = new P(0, 0);

        debug(yDelta_a, yDelta_b, xDelta_a, xDelta_b);

        double aSlope = yDelta_a/xDelta_a;
        double bSlope = yDelta_b/xDelta_b;
        center.x = (aSlope*bSlope*(A.y - C.y) + bSlope*(A.x + B.x)
                - aSlope*(B.x+C.x) )/(2* (bSlope-aSlope) );
        center.y = -1*(center.x - (A.x+B.x)/2)/aSlope +  (A.y+B.y)/2;

        return center;
    }

    static double getAngle2(P a, P b){
        double dot = a.dot(b);
        double av = a.abs(), bv = b.abs();

        double ang = Math.acos(dot / (av*bv));

        ang = ang*180/Math.PI;

        if(ang < 0){
            ang += 360;
        }

        return ang;

    }

    public static double getAngle(P a, P target) {
        double angle = (float) Math.toDegrees(Math.atan2(target.y - a.y, target.x - a.x));

        if(angle < 0){
            angle += 360;
        }

        return angle;
    }

    static double dist(double x1, double y1, double x2, double y2){
        double x = x1-x2, y = y1-y2;
        return Math.sqrt(x*x + y*y);
    }

    static double EPS = 1e-4;


    static class P {
        double x, y;
        P(double x, double y) {
            this.x = x;
            this.y = y;
        }

        double dist(P p){
            double xx = x - p.x;
            double yy = y - p.y;
            return Math.sqrt(xx*xx + yy*yy);
        }

        double distSq(P p){
            double xx = x - p.x;
            double yy = y - p.y;
            return xx*xx + yy*yy;
        }

        long distLongSq(P p){
            long xx = (long)x - (long)p.x;
            long yy = (long)y - (long)p.y;
            return xx*xx + yy*yy;
        }

        P add(P p) {
            return new P(x + p.x, y + p.y);
        }
        P sub(P p) {
            return new P(x - p.x, y - p.y);
        }
        P mul(double d) {
            return new P(x * d, y * d);
        }
        P div(double d) {
            return new P(x / d, y / d);
        }
        double dot(P p) {
            return x * p.x + y * p.y;
        }
        double det(P p) {
            return x * p.y - y * p.x;
        }
        double crossProduct(P that) {
            return this.det(that);
        }
        double abs() {
            return Math.sqrt(abs2());
        }
        double abs2() {
            return x * x + y * y;
        }
        P rot90() {
            return new P(-y, x);
        }
        public String toString() {
            return String.format("(%.2f, %.2f)", x, y);
        }
    }

    static double rad(P p1,P p2){
        return Math.atan2(p1.det(p2),p1.dot(p2));
    }

    static void debug(Object...obj) {
        System.err.println(Arrays.deepToString(obj));
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
            tokenizer = null;
        }

        //InputReader in = new InputReader(new FileReader("File_Name"));
        public InputReader(FileReader file) {
            reader = new BufferedReader(file);
            tokenizer = null;
        }

        public String next() {

            try {
                while (tokenizer == null || !tokenizer.hasMoreTokens())
                    tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                return null;
            }

            return tokenizer.nextToken();
        }

        public String nextLine() {
            String line = null;
            try {
                tokenizer = null;
                line =  reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return line;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
        public boolean hasNext(){
            try {
                while (tokenizer == null || !tokenizer.hasMoreTokens())
                    tokenizer = new StringTokenizer(reader.readLine());
            }
            catch (Exception e) {
                return false;
            }

            return true;

        }
    }
}