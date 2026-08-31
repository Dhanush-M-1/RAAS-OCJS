
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a=0,b=0,c=0;
        for (int i = 0; i < n; i++) {
            int t = in.nextInt();
            a+=t;
        }
        for (int i = 0; i < n-1; i++) {
            int t=in.nextInt();
            b+=t;
        }
        for (int i = 0; i < n-2; i++) {
            int t=in.nextInt();
            c+=t;
        }
        System.out.println(a-b);
        System.out.println(b-c);
        
    
    }
}
