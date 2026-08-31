import java.util.*;
public class cont {
    public static void main(String[]args){
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();
        a/=2;
        int ans =0;
        for(int i=0;i<=b;i++){
            for(int j=0;j<=c;j++){
                if((n-2*j-i)>=0 &&  (n-2*j-i)<=a)
                    ans++;
            }
        }
        System.out.println(ans);
    }
}
