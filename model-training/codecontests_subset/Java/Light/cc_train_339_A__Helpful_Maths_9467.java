/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new
         FileOutputStream(java.io.FileDescriptor.out), "ASCII"), 512);
		BufferedReader k=new BufferedReader(new InputStreamReader(System.in));
		String s=k.readLine();
		List<Integer> arr=new ArrayList<>();
		for(int i=0;i<s.length();i++)
		{
			char c=s.charAt(i);
			if(c!='+')
				arr.add((int)c-48);
		}
		Collections.sort(arr);
		for(int i=0;i<arr.size()-1;i++)
			out.write(arr.get(i)+"+");
		out.write(arr.get(arr.size()-1)+"\n");
		out.flush();
	}
}