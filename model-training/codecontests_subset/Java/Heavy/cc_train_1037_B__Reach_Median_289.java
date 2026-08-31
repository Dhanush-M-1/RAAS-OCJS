import java.util.*;
import java.io.*;
public class Reach_Median
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n,s;
        String i1[] = br.readLine().split(" ");
        n = Integer.parseInt(i1[0]);
        s = Integer.parseInt(i1[1]);
        int a[] = new int[n];
        String i2[] = br.readLine().split(" ");
        int pos = -1;
        for(int i=0;i<n;i++)
            a[i] = Integer.parseInt(i2[i]);
        RandomizeArray(a);
        Arrays.sort(a);
        for(int i=0;i<n;i++)
            pos = a[i] == s ? i : -1;
        long ans = 0;
        if(pos == -1)
        {
            if(s > a[n/2])
            {
                for(int i=n/2;i<n;i++)
                    if(a[i] < s)
                        ans += (1L* (s - a[i]));    
            }
            else
            {
                for(int i=0;i<=n/2;i++)
                    if(a[i] > s)
                        ans += (1L * (a[i] - s));
            }
            
        }
        else
            if(a[n/2] == s)
                ans = 0;
            else if(pos > n/2)
                for(int i=n/2;i<pos;i++)
                    ans += (1L* (s - a[i]));
            else
                for(int i=0;i<=n/2;i++)
                    ans += (1l * (a[i] - s));
        System.out.println(ans);
    }
    public static void RandomizeArray(int[] array)
    {
		Random rgen = new Random();	
		for (int i=0; i<array.length; i++)
		{
		    int randomPosition = rgen.nextInt(array.length);
		    int temp = array[i];
		    array[i] = array[randomPosition];
		    array[randomPosition] = temp;
		}
	}
}