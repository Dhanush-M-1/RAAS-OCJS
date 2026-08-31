import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) { 
        OutputStream outputStream = System.out;
        PrintWriter out = new PrintWriter(outputStream);

        Application solver = new Application();
        solver.solve(System.in, out);

        out.close();
    }
}


class Application {
    public void solve(InputStream in, PrintWriter out) {
        Scanner scanner = new Scanner(in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        int A[] = new int[1006];
        int B[] = new int[1006];
        for (int i = 1; i <= N; i++) {
            A[i] = scanner.nextInt();
            B[A[i]] = i;
        }


        int X = 0;
        int C[] = new int[1006];
        int cN = 0;
        for (int i = 1; i <= N; i++) {
            if (A[i] == 0) {
                int p = i;
                int count = 0;
                boolean found = false;
                boolean hasX = false;
                while (!found) {
                    count++;
                    if (p == K) {
                        X = count;
                        hasX = true;
                    }
                    p = B[p];                    

                    if (p == 0) {
                        found = true;
                    }
                }

                if (!hasX) {
                    C[cN++] = count;
                }                
            }
        }

        int F[] = new int[1006];        
        F[X] = 1;
        for (int i = 0; i < cN; i++) {
            int G[] = new int[1006];
            for (int j = 1; j < 1006; j++) {
                if (F[j] == 1) {
                    G[j] = 1;
                    if (j+C[i] < 1006) G[j+C[i]] = 1;
                }
            }
            F = G;
        }

        for (int i = 1; i < 1006; i++)
            if (F[i] == 1) System.out.println(i);
    }
}
