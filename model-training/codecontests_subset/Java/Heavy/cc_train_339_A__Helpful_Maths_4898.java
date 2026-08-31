import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *
 * @author NN
 */
public class HelpfulMaths 
{
    public static void main(String [] args)throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        
        String [] numbers = s.split("\\+");
        
        int [] ns = new int [numbers.length];
        
        for (int i = 0; i < numbers.length; i++) 
        {
            ns[i] = Integer.parseInt(numbers[i]);
        }
        
        sortAsc(ns);
        
        for(int i = 0;i<numbers.length;i++)
        {
            System.out.print(ns[i]);
            if(i!=ns.length-1)
            {
                System.out.print("+");
            }
        }
        
    }
    public static void sortAsc(int [] a)
    {
        for (int i = 0; i < a.length-1; i++) 
        {
            for (int j = i; j < a.length; j++)
            {
                if(a[i]>a[j])
                {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j]=temp;
                }
            }
        }
    }
}