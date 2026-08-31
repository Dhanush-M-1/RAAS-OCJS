
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        
        int t=in.nextInt();
        for(int i=0;i<t;i++)
        {
            int a=in.nextInt();
            int b=in.nextInt();
            int n=in.nextInt();
            int first=a,second=b;
            n=n%3;
            if(n>1){
                second=(a^b);
            }
            else if(n==0)
            {
                second=a;
            }
            else if(n==1)
            {
                second=b;
            }
            System.out.println(second);
        }
    }
    
}
