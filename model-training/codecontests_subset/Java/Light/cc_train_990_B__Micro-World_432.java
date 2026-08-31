
import java.util.*;





public class test
{
	public static class pair
	{
		public int num;
		public int cnt;
		public pair(int num,int cnt)
		{
			this.num = num;
			this.cnt = cnt;
		}
	}
	
	
    private static Scanner sc = new Scanner(System.in);
    //sc.nextInt()   read int


	public static void main(String[] args)
    {
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int cnt[] = new int[1000001];
		

		
		
		for(int i=0;i<n;i++)
		{
			int x = sc.nextInt();
			cnt[x]++;
		}
		
		
		
		pair data[] = new pair[1000000];
		
		int x = 0;
		for(int i=1;i<=1000000;i++)
		{
			if(cnt[i] > 0)
			{
				pair p = new pair(i,cnt[i]);
				data[x] = p;
				x++;
			}
		}
		
		int answer = 0;
		
		for(int i=0;i<x-1;i++)
		{
			if(data[i].num +k < data[i+1].num)
			{
				answer += data[i].cnt;
			}
		}
		
		
		System.out.print(answer + data[x-1].cnt);


		
	}
}


/*
1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25
26
27
28
29
30
31
32

4  4
5  11
6  9
7  13 
8  12
9  21 
10 19
*/






