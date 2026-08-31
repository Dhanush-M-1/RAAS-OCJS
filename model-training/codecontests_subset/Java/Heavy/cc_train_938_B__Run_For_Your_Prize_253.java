import java.util.Scanner;
   
public class Codeforces {    
    public static void main(String[] args) {
        TaskB Solver = new TaskB();
        Solver.Solve();        
    }   
    private static class TaskB {
        private void Solve() {
            Scanner in = new Scanner(System.in);            
            int n = in.nextInt();
            int ar[] = new int [n];
            for (int i = 0; i < n; i++)
                ar[i] = in.nextInt();            
            int min = 1 << 30, l = 1, r = 1000000;  
            if (n == 1) {
                System.out.println(Math.min(ar[0] - l, r - ar[0]));
                return;
            }
            for (int i = 0; i < n - 1; i++) {
                int d1 = ar[i] - l;
                int d2 = r - ar[i + 1];
                min = Math.min(min, Math.max(d1, d2));
            }
            if (ar[n - 1] - 1 < min)
                min = ar[n - 1] - 1;
            if (r - ar[0] < min)
                min = r - ar[0];
            System.out.println(min);            
        }                        
    }    
}