import java.io.*;
import java.util.*;
public class woodcutters
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = sc.nextInt();
        int[] coordinates = new int[n];
        int[] heights = new int[n];
        for (int i = 0; i < n; i++)
        {
            coordinates[i] = sc.nextInt();
            heights[i] = sc.nextInt();
        }
        if (n == 1)
        {
            out.print(1);
            out.close();
            return;
        }
        int[] stay = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];
        stay[0] = 0;
        left[0] = 1;
        if (coordinates[0] + heights[0] <= coordinates[1])
            right[0] = 1;
        else
            right[0] = 0;
        for (int i = 1; i < n; i++)
        {
            int max = Math.max(Math.max(stay[i - 1], left[i - 1]),right[i - 1]);
            stay[i] = max;
            if (max == stay[i - 1] || max == left[i - 1])
            {
                if (coordinates[i] - heights[i] > coordinates[i - 1])
                    left[i] = max + 1;
                else
                    left[i] = max;
            }
            else 
            {
                if (coordinates[i] - heights[i] > coordinates[i - 1] + heights[i - 1])
                    left[i] = max + 1;
                else
                    left[i] = max;
            }
            if (i != n - 1)
            {
                if (coordinates[i] + heights[i] < coordinates[i+1])
                    right[i] = max + 1;
                else 
                    right[i] = max;
            }
            else
                right[i] = max + 1;
        }
        out.print(Math.max(Math.max(stay[n - 1], left[n - 1]),right[n - 1]));
        out.close();
    }
}