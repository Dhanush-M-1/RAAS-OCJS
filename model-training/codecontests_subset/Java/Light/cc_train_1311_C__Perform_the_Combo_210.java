//package CodeForces;

import java.util.HashMap;
import java.util.Scanner;

public class PerformTheCombo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t>0)
		{
			int n=s.nextInt();
			int m=s.nextInt();
			String str=s.next();
			int arr[]=new int[m];
			for(int i=0;i<m;i++)
			{
				arr[i]=s.nextInt()-1;
			}
			HashMap<Integer,HashMap<Character,Integer>> map=new HashMap<Integer,HashMap<Character,Integer>>();
			HashMap<Character,Integer> temp=new HashMap<>();
			for(int i=0;i<str.length();i++)
			{
				if(temp.containsKey(str.charAt(i)))
				{
					temp.put(str.charAt(i),temp.get(str.charAt(i))+1);
				}
				else
				{
					temp.put(str.charAt(i),1);
				}
				
				HashMap<Character,Integer> small=new HashMap<>();
				for(char ch:temp.keySet())
				{
					small.put(ch,temp.get(ch));
				}
				map.put(i,small);
			}
			int ans[]=new int[26];
			for(int i=0;i<m;i++)
			{
				HashMap<Character,Integer> small=map.get(arr[i]);
				for(char ch:small.keySet())
				{
					ans[ch-'a']=ans[ch-'a']+small.get(ch);
				}
			}
			for(char ch:temp.keySet())
			{
				ans[ch-'a']=ans[ch-'a']+temp.get(ch);
			}
			for(int i=0;i<26;i++)
			{
				System.out.print(ans[i]+" ");
			}
			System.out.println();
			
			t--;
		}

	}

}
