import java.util.Scanner;

public class Codeforces {    
    
    public static void main(String[] args) {           
        TaskA Solver = new TaskA();
        Solver.Solve();
    }
    
    public static class TaskA {                
        public void Solve() {            
            Scanner in = new Scanner(System.in);   
            int s = 0;
            for (int i = 0; i < 5; i++)
                s += in.nextInt();
            if ((s % 5 == 0) && (s / 5 != 0))
                System.out.println(s / 5);
            else
                System.out.println("-1");
        }
    }
}