import java.util.Arrays;
import java.util.Scanner;

public class codeforces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test=sc.nextInt();
        while(test-->0){
            int n=sc.nextInt();
            int count2=0;
            int count3=0;
            while(n%2==0){
                n/=2;
                count2++;
            }
            while(n%3==0){
                n/=3;
                count3++;
            }

            if(n==1 && count2<=count3){
                System.out.println(2*count3-count2);
            }
            else{
                System.out.println(-1);
            }
        }
        
            
        
        
    }

}
