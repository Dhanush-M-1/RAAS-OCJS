import java.util.*;
import java.io.*;
public class Solution
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for(int i = 0; i < t; i++)
        {
            int n = input.nextInt();
            int m = input.nextInt();
            int[] array1 = new int[n];
            int[] array2 = new int[m];
            HashSet<Integer> set = new HashSet<>();
            boolean ptr = false;
            for(int j = 0; j < n; j++)
            {
                int temp = input.nextInt();
                array1[j] = temp;
                set.add(temp);
            }
            for(int j = 0; j < m; j++)
            {
                int temp = input.nextInt();
                array2[j] = temp;
            }
            for(int p = 0; p < m; p++)
            {
                if(set.contains(array2[p]))
                {
                    int a = 1;
                    System.out.println("YES");
                    System.out.print(a);
                    System.out.print(" ");
                    System.out.print(array2[p]);
                    System.out.println();
                    ptr = true;
                    break;
                }
            }
            if(!ptr)
            {
                System.out.println("NO");
            }
        }
    }
}