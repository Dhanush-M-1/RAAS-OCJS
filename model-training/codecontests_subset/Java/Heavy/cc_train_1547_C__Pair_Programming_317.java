import java.io.*;
import java.util.*;
import java.util.Scanner;
public class code
{
    static char[][] field;
    public static void main(String args[])
    {
        int[] monocarp = new int[101],polycarp = new int[101];
        Scanner scan = new Scanner(System.in);
        int test = scan.nextInt(),k,n,m;
        int[] result;
        for(int x = 0; x < test; x++)
        {
            result = solve(scan, monocarp, polycarp);
            for(int s = 0; s < result.length; s++)
            {
                System.out.print(result[s] + " ");
            }
            System.out.println();
        }
    }
    
    public static int[] solve(Scanner scan, int[] mono, int[] poly)
    {
        int k = scan.nextInt(), n = scan.nextInt(), m= scan.nextInt();
        int[] result = new int[n+m];
        for(int x = 1; x <= n; x++)
            mono[x] = scan.nextInt();
        for(int x = 1; x <= m; x++)
            poly[x] = scan.nextInt();
        int nindex = 1, mindex = 1,line = k;
        for(int x = 0; x < n + m; x++)
        {
            if(nindex <=  n && mono[nindex] <= line)
            {
                result[x] = mono[nindex];
                nindex++;
            }
            else if(mindex <= m && poly[mindex] <= line)
            {
                result[x] = poly[mindex];
                mindex++;      
            }
            else
                return new int[]{-1};
            if(result[x] == 0)
                line++;
        }    
        return result;
    }
    
    public static void quickSort(int array[], int low, int high)
    {
        if(low < high)
        {
            int p = partition(array, low, high);
            quickSort(array, low, p - 1);
            quickSort(array, p + 1, high);
        }
    }
    
    public static int partition(int array[], int low, int high)
    {
        int pivot = array[high];
        int i = low - 1;
        for(int j = low; j < high; j++)
        {
            if(array[j] < pivot)
            {
                i++;
                swap(array,i,j);
            }
        }
        i++;
        swap(array, i, high);
        return i;
    }
    
    public static void swap (int array[], int x, int y)
    {
        int z = array[x];
        array[x] = array[y];
        array[y] = z;
    }
    
    public static int binarySearch(int[] array, int l, int r, int key)
    {
        System.out.println("tries");
        int p = (l + r) / 2;
        if(array[p] == key)
        {
            return p;
        }
        else if(l < r)
        {
            if(array[p] > key)
            {
                return binarySearch(array, l, p - 1, key);
            }
            else
            {
                return binarySearch(array, p + 1, r, key);
            }
        }
        else
        {
            return -1;
        }
    }
    
}