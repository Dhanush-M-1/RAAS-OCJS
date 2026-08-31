import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[] a = new int[N+1];
        a[0] = 1;

        int DIV = (int)1e9 + 7;

        for(int i=0; i<M; i++){
            int tmp = scanner.nextInt();
            a[tmp] = -1;
        }

        for(int i=0; i<N; i++){
            if(i+1 == N){
                if(a[i] != -1 && a[i+1]!=-1){
                    a[i+1] += a[i];
                    a[i+1] %= DIV;
                }
            }else{
                // one
                if(a[i+1] != -1 && a[i] != -1){
                    a[i+1] += a[i];
                    a[i+1] %= DIV;
                }
                // two
                if(a[i+2] != -1 && a[i] != -1){
                    a[i+2] += a[i];
                    a[i+2] %= DIV;
                }
            }
        }

        System.out.println(a[N]);
    }
}
