import java.util.*;
import java.math.*;
import java.io.*;

public class solution
{
    public static int findMinTime(int n,int k1,int[][] arr)
    {
        int min = 0;
        ArrayList<Integer> both = new ArrayList<>();
        ArrayList<Integer> alice = new ArrayList<>();
        ArrayList<Integer> bob = new ArrayList<>();
        
        for (int i=0;i<n;i++)
        {
            if (arr[i][1] == 1 && arr[i][2] == 1)
                both.add(arr[i][0]);
            else if (arr[i][1] == 1)
                alice.add(arr[i][0]);
            else if (arr[i][2] == 1)
                bob.add(arr[i][0]);
        }
        
        if ((alice.size()+both.size()) < k1 || (bob.size()+both.size()) < k1)
            return -1;
            
        Collections.sort(alice);
        Collections.sort(bob);
        Collections.sort(both);
        
        int i=0,j=0,k=0;
        int a=0,b=0;
        while (i< both.size() && j<alice.size() && k<bob.size())
        {
            if (both.get(i) > alice.get(j)+bob.get(k))
            {
                min += alice.get(j) + bob.get(k);
                j++;
                k++;
                a++;
                b++;
            }
            else
            {
                min+=both.get(i);
                i++;
                a++;
                b++;
            }
            if (a==k1 && b==k1)
                return min;
        }
        
        while (j==alice.size() && i < both.size() && a < k1)
        {
                min+=both.get(i);
                i++;
                a++;
                b++;
        }
        
        while (k==bob.size() && i < both.size() && b<k1)
        {
                min+=both.get(i);
                i++;
                a++;
                b++;
        }
        
        while (j<alice.size() && a<k1)
        {
            min+=alice.get(j);
            j++;
            a++;
        }
        
        while (k<bob.size() && b<k1)
        {
            min+=bob.get(k);
            k++;
            b++;
        }
        
        return min;
    }
    
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        int[][] arr=new int[n][3];
        
        for (int i=0;i<n;i++)
        {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            arr[i][2] = sc.nextInt();
        }
        
        System.out.println(findMinTime(n , k , arr));
    }
}