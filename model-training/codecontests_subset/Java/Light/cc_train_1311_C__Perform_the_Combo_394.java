import java.io.*;
import java.util.*;
public class Combofight
{
	public static void main(String args[])throws IOException
	{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int t = Integer.parseInt(br.readLine());
	while(t-->0)
	{
	StringTokenizer st = new StringTokenizer(br.readLine());
	int n = Integer.parseInt(st.nextToken());
	int m = Integer.parseInt(st.nextToken());
	String s = br.readLine();
	st= new StringTokenizer(br.readLine());
	int p[] = new int[m];
	for(int i=0;i<m;i++)
		p[i] = Integer.parseInt(st.nextToken());
	Arrays.sort(p);
	int press[] = new int[n+1];
	
	int j=0;
	for(int i=1;i<=n;i++)
	{
		if(i==p[j])
		{
			press[i]++;
			j++;
			i--;
			if(j==m)
				break;
		}
		

	}
	for(int i=n-1;i>=1;i--)
	{
		press[i]+=press[i+1];
	}
	for(int i=n;i>=1;i--)
	{
		press[i]++;
	}
	//for(int i=1;i<=n;i++)
	//	System.out.println(press[i]);
	j=0;
	int alph[] = new int[26];
	for(int i=0;i<n;i++)
	{
		alph[s.charAt(i)-97]+=press[i+1];
	}
	for(int i=0;i<26;i++)
		System.out.print(alph[i]+" ");
	System.out.println();	
	}
	}
}