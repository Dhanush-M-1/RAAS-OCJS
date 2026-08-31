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
        
        int m = (int) Math.ceil((double)p/100 * c);
        c= m-w;
        
        if(c<0) c=0;
        System.out.println(c);
        
        
    }
}