import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static class Segment {
        long x1, y1, x2, y2;
        long a, b, c; // general equation of a line

        public Segment(long x1, long y1, long x2, long y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            a = y2 - y1;
            b = x1 - x2;
            c = -a * x1 - b * y1;
        }

        long cross(long x, long y) {
            return (x2 - x1) * (y - y1) - (y2 - y1) * (x - x1);
        }

        long dot(long x, long y) {
            return (x2 - x1) * (x - x1) + (y2 - y1) * (y - y1);
        }

        long sqNorm() {
            return (y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1);
        }

        double norm() {
            return Math.sqrt(sqNorm());
        }

        double norm(long x, long y) {
            return new Segment(x1, y1, x, y).norm();
        }

        @Override
        public String toString() { // debug
            return "(" + x1 + "," + y1 + "," + x2 + "," + y2 + ")";
        }


    }

    static class Pair {
        long x, y;

        public Pair(long x, long y) {
            this.x = x;
            this.y = y;
        }

        public double distance(Pair p2) {
            return distance(p2.x, p2.y);
        }

        public double distance(long x2, long y2) {
            return Math.sqrt(sqrtDistance(x2, y2));
        }

        public long sqrtDistance(Pair p2) {
            return sqrtDistance(p2.x, p2.y);
        }

        public long sqrtDistance(long x2, long y2) {
            return (x - x2) * (x - x2) + (y - y2) * (y - y2);
        }
    }

    public static void main(String[] args) throws Exception, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        Pair pA, pB, pC;
        st = new StringTokenizer(br.readLine());
        pA = new Pair(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        pB = new Pair(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        pC = new Pair(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        Segment sAB = new Segment(pA.x, pA.y, pB.x, pB.y),
                sBC = new Segment(pB.x, pB.y, pC.x, pC.y);
        if(sAB.cross(pC.x, pC.y) == 0){
            sb.append("NO").append(System.lineSeparator());
        } else {
            if (sAB.sqNorm() == sBC.sqNorm()){
                sb.append("YES").append(System.lineSeparator());
            } else {
                sb.append("NO").append(System.lineSeparator());
            }
        }
        System.out.print(sb.toString());
    }
}
