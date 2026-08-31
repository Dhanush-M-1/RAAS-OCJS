import java.util.*;

/**
 * Created by merlyn on 02/07/2017.
 */
public class ProblemA {

    int c, v0, v1, a, l;

    public ProblemA(int c, int v0, int v1, int a, int l) {
        this.c = c;
        this.v0 = v0;
        this.v1 = v1;
        this.a = a;
        this.l = l;
    }

    public void solve() {
        int cost = 0, readed = 0, speed = v0;
        while (readed < c) {
            cost += 1;
            if (cost == 1) {
                readed += v0;
            } else {
                speed = speed + a > v1 ? v1 : speed + a;
                readed += speed - l;
            }
        }
        System.out.println(cost);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int c = in.nextInt();
            int v0 = in.nextInt();
            int v1 = in.nextInt();
            int a = in.nextInt();
            int l = in.nextInt();
            ProblemA problem = new ProblemA(c, v0, v1, a, l);
            problem.solve();
        }
    }
}