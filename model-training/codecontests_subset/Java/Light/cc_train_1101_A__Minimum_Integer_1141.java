import java.util.*;

public class a{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int l = sc.nextInt();
            int r = sc.nextInt();
            int d = sc.nextInt();
            int ans = 0;
            if(d < l || d > r){
                ans = d;
            }else{
                ans = r + (d - r%d);
            }
            System.out.println(ans);
        }
    }
}