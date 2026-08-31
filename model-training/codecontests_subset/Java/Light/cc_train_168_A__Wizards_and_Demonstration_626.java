import java.util.Scanner;

public class A {

    public static void main(String[] args) {
        A problem = new A();
        problem.solve();
    }

    private void solve() {
        Scanner sc = new Scanner(System.in);
            
        int c = sc.nextInt();
        int w = sc.nextInt();
        int p = sc.nextInt();
        
        c= (int) Math.ceil((double)p*c/100)-w;
        
        System.out.println(Math.max(0, c));
    }
}