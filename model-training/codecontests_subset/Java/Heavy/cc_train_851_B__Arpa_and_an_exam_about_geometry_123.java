import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {
    public static long dist(long[] A, long[] B) {
        return ((long) Math.pow(A[0] - B[0], 2)) + ((long) Math.pow(A[1] - B[1], 2));
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] axaybxbycxcy = br.readLine().split(" ");
        long[] A = new long[]{Long.parseLong(axaybxbycxcy[0]), Long.parseLong(axaybxbycxcy[1])};
        long[] B = new long[]{Long.parseLong(axaybxbycxcy[2]), Long.parseLong(axaybxbycxcy[3])};
        long[] C = new long[]{Long.parseLong(axaybxbycxcy[4]), Long.parseLong(axaybxbycxcy[5])};
        long x1 = A[0], y1 = A[1], x2 = B[0], y2 = B[1], x3 = C[0], y3 = C[1];
        if(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2) == 0) {
            System.out.println("No");
        } else {
            System.out.println(dist(A, B) == dist(B, C) ? "Yes" : "No");
        }
    }
}
