
import java.util.Scanner;


public class Tempppp {

    
    public static void main(String[] args) {
    

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String input = sc.nextLine();
        String q = sc.nextLine();
        int zero=0;
        int one=0;
        for(int i=0 ; i<n ; i++)
        {
            if(q.charAt(i)=='0')
            {
                zero++;
            }
            else
            {
                one++;
            }
        }
        if(zero!=one)
        {
            System.out.println(1);
            System.out.println(q);
        }
        else
        {
            System.out.println(2);
            System.out.print(q.substring(0,1)+" ");
            System.out.print(q.substring(1,n));
        }
    }
}
      

