import java.util.*;

public class CF_653_E {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int k = s.nextInt();
		int arr[][] = new int[n][3];
		PriorityQueue<Integer> p1 = new PriorityQueue<>();
		PriorityQueue<Integer> p2 = new PriorityQueue<>();
		int count = 0;
		for(int i = 0;i<arr.length;++i)
		{
			arr[i][0] = s.nextInt();
			arr[i][1] = s.nextInt();
			arr[i][2] = s.nextInt();
			if(arr[i][1] == 1 && arr[i][2] == 0)
			{
				p1.add(arr[i][0]);
			}
			else if(arr[i][1] == 0 && arr[i][2] == 1)
			{
				p2.add(arr[i][0]);
			}
			else if(arr[i][1] == 1 && arr[i][2] == 1)
			{
				count++;
			}
		}
		
		long tmp1[] = new long[Math.min(p1.size(), p2.size())];
		int tmp2[] = new int[count];
		int w = 0;
		for(int i = 0;i<arr.length;++i)
		{
			if(arr[i][1] == 1 && arr[i][2] == 1)
			{
				tmp2[w++] = arr[i][0];
			}
		}
		Arrays.sort(tmp2);
		int u = 0;
		while(p1.size()>0 && p2.size()>0)
		{
			tmp1[u++]=(long)p1.poll()+p2.poll();
		}
		
		int i = 0,j = 0;
		long ans = 0;
		u=0;
//		System.out.println(tmp1.length + " " + tmp2.length);
		if(tmp1.length + tmp2.length < k)
		{
			System.out.println(-1);
			return;
		}
		
		while(i<tmp1.length && j<tmp2.length && u<k)
		{
			if(tmp1[i] < tmp2[j])
			{
				ans+=(long)tmp1[i];
				i++;
				u++;
			}
			else
			{
				ans+=(long)tmp2[j];
				j++;
				u++;
			}
		}
		while(i<tmp1.length && u<k)
		{
			ans+=(long)tmp1[i];
			i++;
			u++;
		}
		while(j<tmp2.length && u<k)
		{
			ans+=(long)tmp2[j];
			j++;
			u++;
		}
		System.out.println(ans);
	}

}
