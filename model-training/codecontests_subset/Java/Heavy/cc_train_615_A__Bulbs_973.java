

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp[] = br.readLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);
        int a[] = new int[m];
        
        for(int i = 0;i < n;i++)
        {
            temp = br.readLine().split(" ");
            for(int j = 1;j < temp.length;j++)
            {
                a[Integer.parseInt(temp[j]) - 1] = 1;
            }
        }
        
        int count = 0;
        for(int i = 0;i < m;i++)
        {
            if(a[i] == 1)
            {
                count++;
            }
        }
        
        if(count == m)
        {
            System.out.println("YES");
        }
        else
        {
            System.out.println("NO");
        }
        
        br.close();
    }
}
