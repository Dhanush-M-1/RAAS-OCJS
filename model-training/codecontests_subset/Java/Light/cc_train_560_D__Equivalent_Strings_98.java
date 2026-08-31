import java.util.*;
public class mohammad {
    public static void main(String[] args) {
/*        ..................................
                       _oo0oo_
                      o8888888o
                      88" . "88
                      (| ^_^ |)
                      0\  =  /0
                    ___/`---'\___
                  .' \\|     |// '.
                 / \\|||  :  ||M// \
                / _||||| -:- |||||- \
               |   | \\\  -  /// |   |
               | \_|  ''\---/''  |_/ |
               \  .-\__  '-'  ___/-. /
             ___'. .'  /--.--\  `. .'___
          ."" '<  `.___\_<|>_/___.' >' "".
         | | :  `- \`.;`\ _ /`;.`/ - ` : | |
         \  \ `_.   \_ __\ /__ _/   .-` /  /
     =====`-.____`.___ \_____/___.-`___.-'=====
                       `=---=' 	
/*--------------->Mohammad Abohasan<---------------*/
        Scanner sc = new Scanner (System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        s1 = fun(s1);
        s2 = fun(s2);
        if(s1.equals(s2))
            System.out.println("YES");
        else
            System.out.println("NO");
    }
    public static String fun(String s) {
        if(s.length()%2 != 0)
            return s;
        String s11 = fun(s.substring(0, (s.length()/2)));
        String s12 = fun(s.substring(s.length()/2));
        String c1 = s11+s12;
        String c2 = s12+s11;
        if(c1.compareTo(c2) <= 0)
            return c1;
        return c2;
    }
}