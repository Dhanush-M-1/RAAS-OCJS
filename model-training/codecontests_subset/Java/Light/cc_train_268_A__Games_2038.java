import java.lang.ProcessBuilder.Redirect.Type;
import java.util.Arrays;
import java.util.Scanner;
import java.lang.Object;
//import sun.security.util.ArrayUtil;

public class ProblemSolving{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] home = new int[n];
        int[] guest = new int[n];
        int count = 0;
        //int guestCounter = 0;

        for ( int i = 0 ; i < n ; i++)
        {
            home[i] = input.nextInt();
            guest[i] = input.nextInt();
        } 
        for(int i = 0 ; i < home.length ; i ++)
        {
            for(int j = 0; j < guest.length; j ++)
            {
                if(home[i] == guest[j])
                {
                    count+=1;
                }
                else continue;
            }
        }
        System.out.println(count);
        
    }
}