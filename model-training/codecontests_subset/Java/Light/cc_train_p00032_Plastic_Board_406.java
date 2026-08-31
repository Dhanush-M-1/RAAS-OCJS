import java.util.*;

public class Main {

    public static void main(String[] args) {
        int a, b, d, rect=0, dia=0;
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String[] s = sc.next().split(",");
            a = Integer.parseInt(s[0]);
            b = Integer.parseInt(s[1]);
            d = Integer.parseInt(s[2]);
            
            if(a * a + b * b == d * d)
                rect++;
            if(a == b)
                dia++;
        }
        System.out.println(rect);
        System.out.println(dia);
    }
 

}