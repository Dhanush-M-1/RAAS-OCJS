
import java.util.*;

public class RookBishopKing {

    public static void main (String[] args)
    {       
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int total = a*c;
        for (int i=0;i<=1000000;++i){
            int time = b*i + b*c;
            if (time>= total){
                System.out.println(i);
                break;
            }
        }       
        sc.close();
    }
}