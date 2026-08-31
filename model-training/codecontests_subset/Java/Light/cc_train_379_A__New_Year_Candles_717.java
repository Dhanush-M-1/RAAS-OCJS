import java.util.*;

public class pro{
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.close();
        int ans = 0;
        int reswax = 0;
        while(a>0){
            ans += a;
            reswax += a;
            a = reswax/b;
            reswax = reswax%b;
        }
        System.out.println(ans);
    }
}