import java.io.*;
import java.util.*;
public class HackerCup1 {
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ind = 0;
		TreeSet<Long> set = new TreeSet<Long>();
		int j = 0;
		for(long i = 1;i<=(long)1e10;i+=j++)
			set.add(i);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		long ans = 0;
		for(long i:set)
		{
			if(i>k)
				break;
			ans = i;
		}
		System.out.println(arr[(int) (k-ans)]);
	}
}