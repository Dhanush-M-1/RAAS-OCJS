import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.next());
        int[] p = new int[N+1];
     
        for(int i=1; i<=N; i++) {
            p[i] = Integer.parseInt(sc.next());
        }
        
        int count = 0;
        for(int i=1; i<=N; i++) {
            if(p[i] == i) {
                if(i == N) {
                    int w = p[i];
                    p[i] = p[i-1];
                    p[i-1] = w;
                    count++;
                }else {
                    int w = p[i];
                    p[i] = p[i+1];
                    p[i+1] = w;
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
