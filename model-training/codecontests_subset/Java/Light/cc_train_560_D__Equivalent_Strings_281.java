import java.util.Scanner;

public class D560
{
    public static void main(String... xxx)
    {
        Scanner sc = new Scanner(System.in);
        //String ae   = sc.nextLine();
        String a   = sc.nextLine();
        String b   = sc.nextLine();
        String b1 = smallest(a);
        String b2 = smallest(b);
        if (b1.compareTo(b2) == 0) System.out.println("YES");
        else System.out.println("NO");

    }

    static String smallest(String s) {
        if (s.length() % 2 == 1) return s;
        String s1 = smallest(s.substring(0, s.length()/2));
        String s2 = smallest(s.substring(s.length()/2, s.length()));
        if (s2.compareTo(s1) >= 0) return s1 + s2;
        else return s2 + s1;
    }

}
