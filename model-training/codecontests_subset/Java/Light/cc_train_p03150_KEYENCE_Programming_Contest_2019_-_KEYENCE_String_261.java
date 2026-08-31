import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        String S = sc.next();
        sc.close();
        int n = S.length();

        for(int i = 0; i <= n ; i++){
            for(int j = i; j <= n; j++){
                String sub1 = S.substring(0, i);
                String sub2 = S.substring(j, n);
                if((sub1+sub2).equals("keyence")){
                    System.out.println("YES");
                    return;
                }
            }
        }
        System.out.println("NO");
    }
}