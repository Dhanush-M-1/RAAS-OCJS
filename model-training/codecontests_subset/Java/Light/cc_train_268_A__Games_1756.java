import java.util.*;
import java.lang.*;
import java.io.*;


public class agamaes{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = Integer.parseInt(in.nextLine());
		int[][] arr = new int[n][2];
		for (int i = 0; i < n; i++)
		{
			String[] s = in.nextLine().trim().split(" ");
			for (int j = 0; j < s.length; j++)
			{
				arr[i][j] = Integer.parseInt(s[j]);
			}
		}
		Map<Integer, Integer> h = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++)
		{
			if ( h.containsKey(arr[i][0]) ){
				h.put(arr[i][0], h.get(arr[i][0]) + 1);
			}
			else{
				h.put(arr[i][0], 1);
			}
		}
		int count  = 0;
		for (int i = 0; i < n; i++)
		{
			if (h.containsKey(arr[i][1])){
				count += h.get(arr[i][1]);
			}
		}
		System.out.println(count);
	}
}
