import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String k = "keyence";
        String s = sc.next();
        int len = k.length();
        boolean bool = false;
        for(int i = 0; i < len; i++){
            String k1 = k.substring(0,i);
            String k2 = k.substring(i,len);
            int a1 = s.indexOf(k1);
            int a2 = s.lastIndexOf(k2);
            int chk = check(k,s,k1,k2,a1,a2);
            if(a1 != -1 && a2 != -1 && chk >= 2){
                bool = true;
                break;
            }
        }
        System.out.println(bool ? "YES" : "NO");
    }
    
    private static int check(String k, String s, String k1, String k2, int a1, int a2){
        int ret = 0;
        if(a1 == 0) ret++;
        if(a2 + k2.length() == s.length()) ret++;
        if(a1 + k1.length() == a2) ret++;
        return ret;
    }
}
