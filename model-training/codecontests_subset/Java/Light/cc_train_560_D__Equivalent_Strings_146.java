import java.util.Scanner;
public class Code3134 {
    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        String s1,s2;
        s1=sc.next();
        s2=sc.next();
        if(same(s1,s2))System.out.println("YES");
        else System.out.println("NO");
    }
    static boolean same(String a,String b){
        if(a.equals(b))return true;
        if(a.length() % 2 == 0){
            return ((same(a.substring(0, a.length()/2),b.substring(a.length()/2)) && same(b.substring(0, a.length()/2),a.substring(a.length()/2))) || (same(a.substring(0,a.length()/2),b.substring(0,b.length()/2))&&same(a.substring(a.length()/2),b.substring(b.length()/2))));
        }
        return false;
    }
}
