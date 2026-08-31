import java.util.*;

public class Dasda {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String c = s.next();
        String t = s.next();
        if(reducir(c).equals(reducir(t))){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
        
    }

    static String reducir(String s) {
        if (s.length() % 2 == 1){
            return s;
        }
        String a = reducir(s.substring(0, s.length() / 2));
        String b = reducir(s.substring(s.length() / 2));
        if(a.compareTo(b)<0){
            return a+b;
        }
        return b + a;
    }

}
