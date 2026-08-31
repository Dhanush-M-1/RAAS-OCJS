import java.util.*;
class Main
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String x = "keyence";
        int n = s.length();
        int m = x.length();
        String ans = "NO";
        for(int i = 0; i <= 7; i++){
            boolean bl = true;
            boolean flag = false;
            int cnt = -1;
            for(int j = 0; j < i; j++){
                if(n >= m && s.charAt(j) != x.charAt(++cnt)){
                    bl = false;
                }
                flag = true;
            }
            for(int j = n + i - 7; j < n; j++){
                if(n >= m && s.charAt(j) != x.charAt(++cnt)){
                    bl = false;
                }
                flag =true;
            }
            if(bl && flag) ans = "YES";
        }
        if(s.compareTo(x) == 0) ans = "YES";
        System.out.println(ans);
    }
}