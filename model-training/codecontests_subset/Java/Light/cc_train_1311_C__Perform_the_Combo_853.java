import java.io.*;
import java.util.*;
public class Ishu
{
	static int binarySearch(int[] a, int data)
	{
	int beg = 0;
	int end = a.length - 1;
	int mid = (beg + end) / 2;
	while(beg <= end)
		{
		mid = (beg + end) / 2;
		if(a[mid] > data)
			end = mid - 1;
		else if(a[mid] < data)
			beg = mid + 1;
		else
			{
			if(mid - 1 >= 0 && a[mid - 1] == data)
				end = mid - 1;
			else
				return mid;
			}
		}
	return end + 1;
	}
	public static void main(String[] args)
	{
	Scanner scan=new Scanner(System.in);
	int t;
	t=scan.nextInt();
	while(t-->0)
		{
		int n,m,i;
		String str;
		n=scan.nextInt();
		m=scan.nextInt();
		str=scan.next();
		int[] p = new int[m];
		for(i=0;i<m;++i)
			p[i]=scan.nextInt();
		Arrays.sort(p,0,m);
		int[] ch = new int[26];
		for(i=0;i<n;++i)
			{
			ch[str.charAt(i)-'a']++;
			int index = binarySearch(p,i+1);
			if(index < 0)
				index = (-1)*(index) - 1;
		//	System.out.println(index);
			ch[str.charAt(i)-'a'] += (m-index);
			}
		for(i=0;i<26;++i)
			System.out.print(ch[i]+" ");
		System.out.println();
		}	
	}
}
