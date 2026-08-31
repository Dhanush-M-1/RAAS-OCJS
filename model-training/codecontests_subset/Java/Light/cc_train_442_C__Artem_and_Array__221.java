import java.util.Arrays;
import java.util.Scanner;
//import java.util.Vector;

public class MAIN_C {
    static int n;
    static int[] a;
    static int[] b;
    static int p;
    static long ans;
    private static Scanner sc;
    //static Scanner sc = new Scanner(System.in); 
    static int mmin(int x,int y) {
        if(x<y) return x;
        return y;
    }
    public static void main(String[] args) {
        sc = new Scanner(System.in); 
        int i;
        n = sc.nextInt();
        a = new int[n+1];
        b = new int[n+1];
        for(i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            while(p >= 2 && b[p-2] >= b[p-1] && a[i] >= b[p-1]) {
            
                ans += mmin(b[p-2], a[i]);
                p--;
            }
        
            b[p] = a[i];
            p++;
        }

        //int[] c = Arrays.copyOfRange(b, 0, p );
        int[] c = Arrays.copyOf(b, p);
        Arrays.sort(c);

        for(i = 0; i < p-2; i++) {
            ans += c[i];
        }
        System.out.println(ans);
    }
}
