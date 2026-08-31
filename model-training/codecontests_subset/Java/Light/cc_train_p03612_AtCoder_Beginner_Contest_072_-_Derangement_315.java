import java.util.Scanner;
import java.util.Stack;

class Main {

    public static void main(String[] args) {
        new Main().compute();
    }

    void compute() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        boolean[] mustSwap = new boolean[N + 1];
        for (int i = 0; i < N; i++) {
            mustSwap[i] = sc.nextInt() - 1 == i ? true : false;
        }
        mustSwap[N] = false;
        int n = 0;
        for (int i = 0; i < N; i++) {
            if (mustSwap[i]) {
                mustSwap[i] = false;
                mustSwap[i + 1] = false;
                n++;
            }
        }
        System.out.println(n);
    }
}
