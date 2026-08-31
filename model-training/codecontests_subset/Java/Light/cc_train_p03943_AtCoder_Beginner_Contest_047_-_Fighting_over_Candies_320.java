
import java.util.*;

public class Main{
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        String msg = "No";
        if(a + b == c || b + c == a || c + a == b){
            msg = "Yes";
        }
        System.out.println(msg);
    }
}