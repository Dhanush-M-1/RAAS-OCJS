//http://codeforces.com/problemset/problem/545/C

import java.util.*;
import java.io.*;

public class GreedyWood
{
    public static void main(String args[])
    {

        final int LEFT = 0;
        final int RIGHT = 1;
        final int NO = 2;
        Scanner fin = new Scanner(System.in);

        int n = fin.nextInt();

        int loc[] = new int[n];
        int h[] = new int[n];
        //int fallenTreePos[][] = new int[n][2];
    
        for(int i = 0; i < n; ++i)
        {
            loc[i] = fin.nextInt();
            h[i] = fin.nextInt();
            // fallenTreePos[i][LEFT] = loc[i] - h[i];
            // fallenTreePos[i][RIGHT] = loc[i] + h[i];
        }

        int max = 1;
        int validPos = loc[0];
        int currentTree = 0;
        
        for(int i = 1; i < n-1; ++i)
        {
            currentTree = loc[i];
            if(currentTree - h[i] > validPos)
            {
                max++;
                validPos = currentTree;
            }
            else if (currentTree + h[i] < loc[i+1])
            {
                max++;
                validPos = currentTree + h[i];
            }
            else
            {
                validPos = currentTree;
            }
        }

        if(n > 1)
        {
            max++;
        }
        System.out.println(max);
    }
}