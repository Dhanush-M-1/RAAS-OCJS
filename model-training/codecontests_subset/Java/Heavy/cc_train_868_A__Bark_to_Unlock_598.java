import java.util.Scanner;
public class P868A {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        String ps;
        ps = scr.next();
        int n;
        n = scr.nextInt();
        String tr;
        boolean a=false,b=false,eq=false;
        for(int i=0;i<n;i++){
            tr = scr.next();
            if(tr.charAt(0)==ps.charAt(1))
                a = true;
            if(tr.charAt(1)==ps.charAt(0))
                b = true;
            if(tr.charAt(0)==ps.charAt(0)&&tr.charAt(1)==ps.charAt(1))
                eq = true;
        }
        if((a&&b)||eq)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
