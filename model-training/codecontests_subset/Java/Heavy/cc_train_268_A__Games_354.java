import java.lang.*;
import java.util.*;

public class Google{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        String input = scan.nextLine();
        for(int i =0; i<n-1; i++)
        {
            input = input + " " + scan.nextLine();
        }
        String[] numbers = input.split(" ");
        int sum = 0;
        for(int i=0; i< n*2; i = i+2)
        {
            int host = Integer.parseInt(numbers[i]);
            for(int j=1; j<n*2; j = j+2)
            {
                int outer = Integer.parseInt(numbers[j]);
                if(outer == host)
                    sum = sum +1;
            }
        }
        
        System.out.println(sum);
        
    }
}