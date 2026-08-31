import java.util.*;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] c = new int[4];
        String[] str = {"AC", "WA", "TLE", "RE"};
        for(int i = 0; i < n; i++) {
            String s = sc.next();
            for(int j = 0; j < 4; j++) {
                if(s.equals(str[j])) {
                    c[j]++;
                    break;
                }
            }
        }
        for(int i = 0; i < 4; i++) {
            System.out.println(str[i] + " x " + c[i]);
        }
    }
}
