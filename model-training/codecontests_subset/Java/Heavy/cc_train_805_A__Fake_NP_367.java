import java.util.Scanner;


public class Comparision {
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        
        int a = s.nextInt();
        int b = s.nextInt();
        
        if(b - a > 3)
        {
            System.out.println(2);
        }
        
        else if(b - a == 0)
            System.out.println(a);
        
        else {
            int x;
            if(a > 20)
                x = 20;
            else x = a;
            int[] arr = new int[x+1];
            for(int i = 2 ; i <= x ; i++)
            {
                for(int j = a; j <= b ; j++)
                {
                    if(j % i == 0)
                        arr[i]++;
                }
            }
            
        arr[0] = -1;
        int max = 0;
        int i;
        for( i = 1 ; i <= x ; i++)
        {
            if(arr[i] > arr[max])
                max = i;
        }
        
        System.out.println(max);
        }
        
        
        
        
    }
    
}
