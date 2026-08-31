import java.awt.geom.Line2D;
import java.util.Scanner;


public class CF_613_A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        double cx, cy;
        n = in.nextInt(); cx = in.nextInt(); cy = in.nextInt();
        int[] xV = new int[n];
        int[] yV = new int[n];
        Line2D[] segs = new Line2D.Double[n];
        double maxDist = Double.MIN_VALUE, minDist = Double.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            xV[i] = in.nextInt();
            yV[i] = in.nextInt();
            if(Math.sqrt(Math.pow(xV[i]-cx,2) + Math.pow(yV[i]-cy,2)) > maxDist) {
                maxDist = Math.sqrt(Math.pow(xV[i] - cx, 2) + Math.pow(yV[i] - cy, 2));
            }
        }
        for (int i = 0; i < n; i++) {
            segs[i] = new Line2D.Double(xV[i], yV[i], xV[(i+1)%n], yV[(i+1)%n]);
            if(segs[i].ptSegDist(cx, cy) < minDist) minDist = segs[i].ptSegDist(cx, cy);
        }
        double outer = Math.PI * Math.pow(maxDist, 2);
        double inner = Math.PI * Math.pow(minDist, 2);
        System.out.println(outer - inner);
    }
}
