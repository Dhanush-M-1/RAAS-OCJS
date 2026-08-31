import java.util.*;

public class multipleORdivide{
    public static void main(final String[]args){
        final Scanner sc = new Scanner (System.in);
        final int t = sc.nextInt();
        for(int i = 0 ; i < t ; i ++){
            int n = sc.nextInt();
            int count = 0;
            while(true){
                if(n%3!=0 && n%6!=0) break;
                else if(n == 1) break;
                else if(n%6==0){
                    n /= 6 ;
                    count++;
                }
                else if(n%3==0){
                    n /= 3 ;
                    count+=2;
                }
            }
            if(n==1)
                System.out.println(count);
            else
                System.out.println(-1);
        }
    }
}