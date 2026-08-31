import java.util.*;
import java.awt.Point;
public class Main
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int c = in.nextInt();
        for(int i = 0; i < c ; i++)
        {
            int d = in.nextInt();
            int[] arr = new int[d];
            for(int j = 0; j < d; j++)
            {
                arr[j] = in.nextInt();
            }
            if(arr[0] + arr[1] <= arr[arr.length -1])
            {
                System.out.println("1 2 " + (arr.length));
            }
            else
            {
                System.out.println(-1);
            }
            
        }
            
            
        
    }
}