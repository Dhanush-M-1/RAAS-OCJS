import java.util.Scanner;

public class Codeforces {    
    
    public static void main(String[] args) {           
        TaskA Solver = new TaskA();
        Solver.Solve();
    }
    
    public static class TaskA {        
        public void Solve() {            
            Scanner in = new Scanner(System.in); 
            int n = in.nextInt();            
            int s1 = 0, s2 = 0, s3 = 0;
            for (int i = 0; i < n; i++) 
                s1 += in.nextInt();
            for (int i = 0; i < n - 1; i++) 
                s2 += in.nextInt();
            for (int i = 0; i < n - 2; i++) 
                s3 += in.nextInt();                       
            System.out.println(s1 - s2);
            System.out.println(s2 - s3);                
        }        
    }
}