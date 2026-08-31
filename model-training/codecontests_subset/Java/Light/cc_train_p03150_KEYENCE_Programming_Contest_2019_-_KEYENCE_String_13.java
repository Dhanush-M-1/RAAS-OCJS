import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Main m = new Main(sc);
        m.show(m.solve());
    }
    
    Scanner sc;
    String S;
    boolean answer = false;
    
    //入力
    Main(Scanner sc) {
        this.sc = sc;
        S = sc.next();
    }
    
    //解答処理
    boolean solve() {
        String str = null;
        String a = null;
        String b = null;
        for (int i=0; i<S.length(); ++i){
            for (int j=i; j<S.length(); ++j){
                a = S.substring(0,i);
                b = S.substring(j,S.length());
                str = a+b;
                if (str.equals("keyence") || str.equals("key of science")){
                    answer = true;
                    break;
                }
            }
        }
        
        return answer;
    }
    
    //出力
    void show(boolean answer) {
        if (answer){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}