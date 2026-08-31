import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ChessForThree {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];
        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(br.readLine());
        }

        int w=1, l=2, s=3;
        for(int i=0; i<n; i++){
            if(a[i] == s){
                System.out.println("NO");
                return;
            } else {
                if(a[i]==w){
                    int temp = s;
                    s = l;
                    l = temp;
                } else {
                    int temp = s;
                    s = w;
                    w = temp;
                }
            }
        }
        System.out.println("YES");
    }
}
