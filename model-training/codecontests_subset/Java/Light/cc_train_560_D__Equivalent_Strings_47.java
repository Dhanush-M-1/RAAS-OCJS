import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();
        if(s1.length()%2==0){
            if(ordered(s1).equals(ordered(s2)))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
        else{
            if(s1.equals(s2))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
    public static String ordered(String s){
        if(s.length()%2==1)
            return s;
        String s1 = ordered(s.substring(0,s.length()/2));
        String s2 = ordered(s.substring(s.length()/2));
        if(s1.compareTo(s2)>=0)
            return s2+s1;
        return s1+s2;
    }
}