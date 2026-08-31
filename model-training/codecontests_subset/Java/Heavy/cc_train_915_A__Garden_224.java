import java.lang.*;
    import java.util.*;

    public class Main {
        static Scanner in = new Scanner(System.in);

        public static void main(String[] args) {

            solve();
            //solve_time();

        }
        static void solve() {
         int n = in.nextInt();
         int l = in.nextInt();
         int[] mass = new int[n];
         int cnt = 0;
            for (int i = 0; i < mass.length; i++) {
                int z = in.nextInt();
                if (z <= l && l%z==0) {
                    mass[i] = z;
                    cnt++;
                }
            }
            Arrays.sort(mass);
            System.out.println(l/mass[mass.length-1]);
        }
        }




