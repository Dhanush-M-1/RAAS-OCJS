import java.io.BufferedReader;
import java.io.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.*;

public class Solution {
	public static void main(final String args[]) throws IOException {
		//getDataFromFile();
		final Scanner in = new Scanner(System.in);
		// BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		int t=in.nextInt();
		while(t-->0)
		{
			int m,n;
			boolean flag = false;
			m=in.nextInt();
			n=in.nextInt();
			Set<Integer> seta = new TreeSet<Integer>();
			Set<Integer> setb = new TreeSet<Integer>();
			for(int i=0;i<m;i++)
			{
				seta.add(in.nextInt());
			}
			
			for(int i=0;i<n;i++)
			{
				setb.add(in.nextInt());
		
			}
			// System.out.println(seta+" "+setb);
			seta.retainAll(setb);
			// System.out.println(seta);
			if(seta.size()==0)
			{
				System.out.println("NO");
			}
			else
			{
				Iterator iterator=seta.iterator();
				System.out.println("YES");
				System.out.println("1 "+iterator.next());
			}

		}
		
		in.close();
	}


	
	
	static void getDataFromFile() {
		try {
			final FileInputStream fin = new FileInputStream(new File("input.txt"));
			System.setIn(fin);
			PrintStream o = null;
			PrintStream err = null;
			o = new PrintStream(new File("output.txt"));
			err = new PrintStream(new File("error.txt"));
			System.setOut(o);
			System.setErr(err);
		} catch (final FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}