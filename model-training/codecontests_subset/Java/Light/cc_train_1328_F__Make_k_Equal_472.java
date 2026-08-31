import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class notYet {
	
	
	public static void main(String[] args)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st1.nextToken());
		int k = Integer.parseInt(st1.nextToken());
		
		Integer arr[] = new Integer[n];
		
		st1 = new StringTokenizer(br.readLine());
		
		int cnt[] = new int[200000 + 1];
		boolean flag = false;
		HashMap<Integer, Integer> hm = new HashMap<>();
		
		for(int i = 0 ; i < n ; i++)
		{
			arr[i] = Integer.parseInt(st1.nextToken());
			cnt[arr[i]]++;
			
			hm.put(arr[i], 0);
			
			if(cnt[arr[i]] >= k)
			{
				flag = true;
			}
		}
		
		Arrays.sort(arr);
		if(flag)
			out.println(0);
		else
		{
			int min = Integer.MAX_VALUE;
			for(int i = 0 ; i < n ; i++)
			{
				
					
				
				int gCnt = 0;
				int x = arr[i];
				while(x > 0)
				{
					x = x / 2;
					gCnt++;
					cnt[x]++;
					hm.put(x, hm.getOrDefault(x, 0) + gCnt);
					if(cnt[x] >= k)
					{
						min = Math.min(min, hm.get(x));
					}
					
				}
				
			
			}
			
			out.println(min);
		}
			
		
		
		
		out.flush();
		out.close();
	}
	
	
	


}
