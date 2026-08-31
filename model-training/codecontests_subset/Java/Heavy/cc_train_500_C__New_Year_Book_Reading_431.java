import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C500 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int M = input.nextInt();
        int[] W = new int[N];
        for (int n=0; n<N; n++) {
            W[n] = input.nextInt();
        }
        int[] B = new int[M];
        for (int m=0; m<M; m++) {
            B[m] = input.nextInt()-1;
        }
        int answer = 0;
        List<Integer> stack = new ArrayList<Integer>();
        for (int m=0; m<M; m++) {
            int index = stack.indexOf(B[m]);
            if (index == -1) {
                index = stack.size();
            }
            for (int i=0; i<index; i++) {
                answer += W[stack.get(i)];
            }
            if (index < stack.size()) {
                stack.remove(index);
            }
            stack.add(0, B[m]);
        }
        System.out.println(answer);
    }

}
