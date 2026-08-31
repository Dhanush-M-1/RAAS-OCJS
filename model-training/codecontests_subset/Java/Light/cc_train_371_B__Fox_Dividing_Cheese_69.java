import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FoxDividingCheese {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int f [] ={2,3,5};
        int [] fa = new int[6];
        int [] fb = new int[6];
        for (int i = 0; i < 3; i++) {
            while (a%f[i]==0){
                fa[f[i]]++;
                a /= f[i];
            }
            while (b%f[i]==0){
                fb[f[i]]++;
                b /= f[i];
            }
        }
        if (a!=b){
            System.out.print(-1);
            return;
        }
        int ans=0;
        for (int i = 0; i < 6; i++) {
            ans +=  Math.abs(fa[i]-fb[i]);
        }
        System.out.print(ans);
    }
}
