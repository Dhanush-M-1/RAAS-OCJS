import java.util.*;
public class maths {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        String s1=new String();
        s1=s.next();
        int x=0;
        int a[]=new int[s1.length()/2+1];
        for (int i=0;i<s1.length();i+=2) {
            a[x++]=(int)(s1.charAt(i))-48;
        }
        Arrays.sort(a);
        int y=0;
        for (int i=0;i<s1.length();i++ ) {
            if (i%2==0) {
                System.out.print(a[y++]);
            }
            else
                System.out.print("+");
        }

    }
}