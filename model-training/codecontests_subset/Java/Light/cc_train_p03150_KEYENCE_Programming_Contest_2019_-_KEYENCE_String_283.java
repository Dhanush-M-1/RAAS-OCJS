import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) throws Exception {
        String s = sc.next();
        boolean[] bs = {
            s.matches(".*keyence"),
            s.matches("k.*eyence"),
            s.matches("ke.*yence"),
            s.matches("key.*ence"),
            s.matches("keye.*nce"),
            s.matches("keyen.*ce"),
            s.matches("keyenc.*e"),
            s.matches("keyence.*")
        };
        
        for(int i = 0; i < 8; ++i) {
            if(bs[i]) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }
}
