
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t>0){
            int k = in.nextInt();
            int n = in.nextInt();
            int m = in.nextInt();

            int[] mono = new int[n];
            int[] poly = new int[m];
            int[] combo = new int[m+n];

            for (int i=0; i<n; ++i){
                mono[i] = in.nextInt();
            }
            for (int i=0; i<m; ++i){
                poly[i] = in.nextInt();
            }

            int cn = 0;
            int cm = 0;
            int cc = 0;
            boolean flag = true;

            while (cm<m && cn<n){
                if (mono[cn] == 0){
                    combo[cc] = 0;
                    ++cn;
                    ++cc;
                    ++k;
                }
                else if (mono[cn] <= k){
                    combo[cc] = mono[cn];
                    ++cn;
                    ++cc;
                }
                else if (poly[cm] == 0){
                    combo[cc] = 0;
                    ++cm;
                    ++cc;
                    ++k;
                }
                else if (poly[cm] <= k){
                    combo[cc] = poly[cm];
                    ++cm;
                    ++cc;
                }
                else{
                    flag = false;
                    cm = m;
                }
            }
            if (!flag){
                System.out.println(-1);
            }
            else{
                boolean flag2 = true;
                while (cn<n){
                    if (mono[cn] == 0){
                        combo[cc] = 0;
                        ++cn;
                        ++cc;
                        ++k;
                    }
                    else if (mono[cn] <= k) {
                        combo[cc] = mono[cn];
                        ++cn;
                        ++cc;
                    }
                    else{
                        flag2 = false;
                        cn = n;
                    }
                }
                while (cm<m){
                    if (poly[cm] == 0){
                        combo[cc] = 0;
                        ++cm;
                        ++cc;
                        ++k;
                    }
                    else if (poly[cm] != 0 && poly[cm] <= k) {
                        combo[cc] = poly[cm];
                        ++cm;
                        ++cc;
                    }
                    else{
                        flag2 = false;
                        cm = m;
                    }
                }
                if (flag2) {
                    for (int i = 0; i < cc; ++i) {
                        System.out.print(combo[i] + " ");
                    }
                }
                else{
                    System.out.print(-1);
                }
                System.out.println();
            }

            --t;
        }

    }
}
