import java.util.*;
import java.io.*;
public class Solution{
    public static void main(String arg[]){
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while (t > 0)
        {
		    int i, n = scan.nextInt();
			String [] arr = new String[n];
			int [][] arr1 = new int[2][2];
			for (i = 0; i < n; ++i)
			{
			arr[i] = scan.next();
			}
			if (arr[0].charAt(1) == '1')
			{
			arr1[0][1]++;
			}
			if (arr[1].charAt(0) == '1')
			{
			arr1[0][0]++;
			}
			if (arr[n - 1].charAt(n - 2) == '1')
			{
			arr1[1][0]++;
			}
			if (arr[n - 2].charAt(n - 1) == '1')
			{
			arr1[1][1]++;
			}
			if (arr1[0][0] == arr1[0][1] && arr1[1][0] == arr1[1][1] && arr1[0][0] == arr1[1][0])
			{
			System.out.println("2");
			System.out.println("1 2");
			System.out.println("2 1");
			}
			else if (arr1[0][0] == arr1[0][1] && arr1[1][0] == arr1[1][1] && arr1[0][0] != arr1[1][0])
			{
			System.out.println("0");
			}
			else if (arr1[0][0] == arr1[0][1] && arr1[1][0] != arr1[1][1])
			{
			System.out.println("1");
			if (arr1[1][0] == arr1[0][0])
			{
			System.out.println(n + " " + (n - 1));
			}
			else
			{
			System.out.println(n - 1 + " " + n);
			}
			}
			else if (arr1[0][0] != arr1[0][1] && arr1[1][0] == arr1[1][1])
			{
			System.out.println("1");
			if (arr1[0][0] == arr1[1][0])
			{
			System.out.println(2 + " " + 1);
			}
			else
			{
			System.out.println(1 + " " + 2);
			}
			}
			else 
			{
			System.out.println("2");
			System.out.println(2 + " " + 1);
			if (arr1[1][0] == arr1[0][1])
			{
			System.out.println(n + " " + (n - 1));
			}
			else
			{
			System.out.println(n - 1 + " " + n);
			}
			}
            t--;
        }
    }
}