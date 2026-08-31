import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // Your code here!
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = str.length();
        
        int count = 0;
        int now = 0;
        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            
            if (c == 'S') {
                now++;
            } else {
                now--;
            }
            
            if (now < 0) {
                count++;
                now = 0;
            }
        }
        
        if (now > 0) {
            count += now;
        }
        System.out.println(count);
    }
}
