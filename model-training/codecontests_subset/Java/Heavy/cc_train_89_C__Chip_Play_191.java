/*

Author: Yiu Yu Ho
Creation: <Creation Date>
Last Updated: <Last Updated Date>
*/

import java.io.*;
import java.util.*;

public class ChipPlay
{
	public Scanner in = new Scanner(System.in);
	public PrintStream out = System.out;

	public String D = "LRUD";
	
	public class Chip
	{
		public int K = -1;
		public int dir;
		public Chip[] v;
		public Chip[] mem;
		
		public String ID;
		
		public Chip(char c)
		{
			dir = D.indexOf(c);
			v = new Chip[4];
			mem = new Chip[4];
		}
		
		public void restore()
		{
			for(int i = 0; i < 4; ++i) v[i] = mem[i];
			//v = mem.clone();
		}
	}
	
	public Chip[][] T;
	public int rn, cn;
	public ArrayList<Chip> C;
	
	public final int left = D.indexOf('L');
	public final int right = D.indexOf('R');
	public final int up = D.indexOf('U');
	public final int down = D.indexOf('D');	
	
	public int master = 0;
	
	public void main()
	{
		rn = in.nextInt();
		cn = in.nextInt();
		T = new Chip[rn][cn];
		C  =new ArrayList<Chip>();
		
		for(int i = 0; i < rn; ++i)
		{
			char[] a = in.next().toCharArray();
			for(int j = 0; j < cn; ++j)
			{
				if(a[j] != '.') 
				{
					T[i][j] = new Chip(a[j]);
					C.add(T[i][j]);
					T[i][j].ID = "(" + i + ", " + j + ")";
				}
			}
		}
		
		makeLeftUp();
		makeDownRight();
		
		int count = 0;
		int best = 0;
		
		restore();
		for(int i = 0; i < rn; ++i)
		for(int j = 0; j < cn; ++j)
		{			
			++master;
			int x = go(T[i][j]);
			
			if(x > best)
			{
				best = x;
				count = 1;
			}
			else if(x == best) ++count;
		}
		
		out.println(best + " " + count);
		
	}//end public void main()
	
	public int go(Chip x)
	{
		int res = 0;
		
		ArrayList<Chip> A = new ArrayList<Chip>();
		
		while(x != null)
		{
			++res;
			
			Chip L = x.v[left];
			Chip R = x.v[right];
			Chip U = x.v[up];
			Chip D = x.v[down];
			
			if(L != null) 
			{
				L.v[right] = R;
				add(A, L);
			}
			
			if(R != null) 
			{
				R.v[left] = L;
				add(A, R);
			}
			
			if(U != null) 
			{
				U.v[down] = D;
				add(A, U);
			}
			
			if(D != null) 
			{
				D.v[up] = U;
				add(A, D);
			}
			
			x = x.v[x.dir];
		}
		
		for(Chip c : A) 
		{
		//	System.err.println("Restoring Chip " + c.ID);
			c.restore();
		}
		
		return res;
	}
	
	public void add(ArrayList<Chip> A, Chip c)
	{
		//System.err.println("c.K = " + c.K + ", master = " + master);
		if(c.K != master)
		{
			c.K = master;
			A.add(c);
		}
	}
	
	public void restore()
	{
		for(Chip c : C) c.restore();
	}
	
	public void makeLeftUp()
	{	
		Chip[] U = new Chip[cn];
		Chip L = null;
		
		for(int i = 0; i < rn; ++i)
		{
			L = null;
			for(int j = 0; j < cn; ++j)
			{
				if(T[i][j] != null)
				{
					T[i][j].mem[left] = L;
					T[i][j].mem[up] = U[j];
					
					L = T[i][j];
					U[j] = T[i][j];
				}
			}
		}
	}
	
	public void makeDownRight()
	{		
		for(int i = 0; i < rn; ++i)
		for(int j = 0; j < cn; ++j) if(T[i][j] != null)
		{
			Chip L = T[i][j].mem[left];
			Chip U = T[i][j].mem[up];
			
			if(L != null) L.mem[right] = T[i][j];
			if(U != null) U.mem[down] = T[i][j];
		}
	}
	
//----------------- Pre-Written Code -------------------------------------------	
//----------------- Ends Pre-Written Code --------------------------------------

	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
	
		(new ChipPlay()).main();
		
		long endTime = System.currentTimeMillis();

		long ms = endTime - startTime;
		long sec = ms/1000; ms = ms%1000;
		long min = sec/60; sec = sec%60;

		System.err.println("Time Spent: " + min + " minute(s) " + sec + " second(s) " + ms + " (ms)");		
	}
}