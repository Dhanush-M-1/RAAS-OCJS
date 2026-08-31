import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, A, B, C, i;
        N = sc.nextInt();
        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();
        int [] D = new int[N];
        for(i = 0; i < N; i++){
            D[i] = sc.nextInt();
        }
        Arrays.sort(D);
        for(i = N - 1; i >= 0; i--){
          if((double)D[i] / B > (double)C / A){
               C = C + D[i];
               A = A + B;
              }
        }
        System.out.println(C/A);
    }
}