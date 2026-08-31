import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.next());
        long sum = 0;
        for(int i = 0; i < N; i++) {
            sum += Integer.parseInt(sc.next()) - 1;
        }
    
        System.out.println(sum);
        
    }
}