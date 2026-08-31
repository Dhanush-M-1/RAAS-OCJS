import java.io.*;
public class A{
	public static void main(String ar[])throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0)
		{
			int n = Integer.parseInt(br.readLine());
			String str[] = br.readLine().split(" ");
			
			long arr[] = new long[n];
			
			for(int i = 0;i<n;i++)
			{
				arr[i] = Long.parseLong(str[i]);
			}
			
			//we will solve this problem by greedy technique 
			// we dont know what is ahead of i element so we will decrese i as we can redcued it so
			
			int left = 0;
			for(int i = 0;i<n;i++)
			{
				if(arr[i] >= i)
				{
					left = i;
					
				}
				else break;
			}
			
			// so we were able to decrese it upto left index but if left index on not n then ?
			// it can be  a inc dec array so 
			
			int right = n-1;
			int j = 0;
			for(int i = n-1;i>= 0 ;i--)
			{
				if(arr[i] >= j)
				{
					right = i;
					j++;
				}
				else break;
			}
			
			// if right and left collide then it is a sharpened array
			
			if(right <= left)
			{
				System.out.println("YES");
			}
			else
			{
				System.out.println("NO");
			}

			
			
		}
	}
}
