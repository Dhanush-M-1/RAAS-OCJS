import java.util.*;

public class ques1 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            HashSet<Integer> hs = new HashSet<>();
            int M = sc.nextInt();
            int[] A = new int[N];
            int[] B = new int[M];
            for (int i = 0; i < N; i++) A[i] = sc.nextInt();
            for (int j = 0; j < M; j++) B[j] = sc.nextInt();

            for (int u = 0; u < N; u++) {
                hs.add(A[u]);
            }
            int flag=0;
            for (int h = 0; h < M; h++) {
                if (hs.contains(B[h])) {
                    System.out.println("YES");
                    System.out.println(1 + " " + B[h]);
                    flag=1;
                    break;
                }
            }
            if(flag==0){
                System.out.println("NO");
            }
        }
    }
}