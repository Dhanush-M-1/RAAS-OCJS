import java.io.*;
import java.util.*;
public class BS
{
	public static void main(String[] ar)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//int t = Integer.parseInt(br.readLine()),x=0,val=0;
		//while(t-->0)
		//{
			String s1 = br.readLine();
			int len = s1.length();
			ArrayList<Integer> arr = new ArrayList<Integer>();
			for(int i=0;i<len;i+=2)
				arr.add(Integer.parseInt(Character.toString(s1.charAt(i))));
			Collections.sort(arr);
			int len1=arr.size();
			for(int i=0;i<len1-1;i++)
				System.out.print(arr.get(i)+"+");	
			System.out.print(arr.get(len1-1));
	}
}