import java.util.Scanner;

public class A {
    public static void main(String args[]){
            Scanner in = new Scanner(System.in);
            String a = in.next();
            String b = in.next();
//          System.out.println(check(a));
//          System.out.println(check(b));
            if(check(a).equals(check(b)))
                System.out.println("YES");
            else
                System.out.println("NO");
    }
    
    public static String check(String a){
        if(a.length()%2==1)
            return a;
        if(a.length()==2){
            if(a.charAt(0)>a.charAt(1))
                return a.charAt(1)+""+a.charAt(0);
            else
                return a.charAt(0)+""+a.charAt(1);
        }
        String s1 = a.substring(0,a.length()/2) ;
        String s2 = a.substring(a.length()/2,a.length()) ;
        String tmp1 = check(s1);
        String tmp2 = check(s2);
        int ind = s1.length();
        for(int i = 0 ; i < ind ; i++)
            if(tmp1.charAt(i)<tmp2.charAt(i))
                return tmp1+tmp2;
            else if(tmp1.charAt(i)>tmp2.charAt(i))
                return tmp2+tmp1;
        return tmp1+tmp2;
    }
}
