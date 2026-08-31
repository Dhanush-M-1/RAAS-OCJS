import java.util.*;
    
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        int t = (int) Math.ceil((c*(a-b))/b);
        System.out.println(t < 0 ? 0 : t );
    }
}