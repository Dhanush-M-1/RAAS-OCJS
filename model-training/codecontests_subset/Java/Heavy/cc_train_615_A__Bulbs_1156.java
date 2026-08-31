
import java.util.Scanner;

public class Bulbs 
{
    private static Scanner sc;
    public static void main(String[] cd)
    {
        sc = new Scanner(System.in);
        int m,n;
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();
        int[] arr = new int[101];
        for(int i=0;i<n;i++)
        {
            String s[] = sc.nextLine().split(" ");
            for(int j=1;j<s.length;j++)
            {
                arr[Integer.parseInt(s[j])-1]=1;
            }
        }
        
        for(int i=0;i<m;i++)
        {
            if(arr[i] < 1)
            {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
        return;
    }
}



