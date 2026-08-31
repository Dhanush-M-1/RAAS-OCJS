import java.util.Scanner;

public class B1421 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t=0; t<T; t++) {
            int N = in.nextInt();
            char[][] A = new char[N][];
            for (int r=0; r<N; r++) {
                A[r] = in.next().toCharArray();
            }
            if (A[N-1][N-2] == A[N-2][N-1]) {
                if (A[0][1] == A[1][0]) {
                    if (A[0][1] == A[N-1][N-2]) {
                        System.out.println("2");
                        System.out.println("1 2");
                        System.out.println("2 1");
                    } else {
                        System.out.println("0");
                    }
                } else {
                    System.out.println("1");
                    if (A[N-1][N-2] == A[0][1]) {
                        System.out.println("1 2");
                    } else {
                        System.out.println("2 1");
                    }
                }
            } else {
                if (A[0][1] == A[1][0]) {
                    System.out.println("1");
                    if (A[0][1] == A[N-1][N-2]) {
                        System.out.println(N + " " + (N-1));
                    } else {
                        System.out.println((N-1) + " " + N);
                    }
                } else {
                    System.out.println("2");
                    if (A[0][1] == '1') {
                        System.out.println("1 2");
                    } else {
                        System.out.println("2 1");
                    }
                    if (A[N-1][N-2] == '0') {
                        System.out.println(N + " " + (N-1));
                    } else {
                        System.out.println((N-1) + " " + N);
                    }
                }
            }
        }
    }

}
