import java.util.Scanner;


public class SolutionCF1101A {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        
        for (int i = 0; i < q; i++) {
            int l = scan.nextInt();
            int r = scan.nextInt();
            int d = scan.nextInt();
            int res = d;
            if (d < l || d > r) {
                System.out.println(res);
            } else {
                System.out.println(res + ((r - res)/res + 1) * res);
            }
        }
        
    }
    
}