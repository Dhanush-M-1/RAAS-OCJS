

import java.io.*;
import java.util.*;

public class nybreading {
	BufferedReader f;
	int nn;
	int mm;
	int [] wt;
	int [] bk;
	int [] order;
	int minwt;
	
	public nybreading() throws Exception
	{
		f = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(f.readLine()); 
		nn = Integer.parseInt(st.nextToken());
		mm = Integer.parseInt(st.nextToken());		
		// System.out.println("nn = " + nn + ", tt = " + tt);
		
		wt = new int[nn];
		st = new StringTokenizer(f.readLine()); 
		for(int i = 0; i < nn; i++)
		{
			wt[i] = Integer.parseInt(st.nextToken());
			// System.out.println("wt = " + wt[i]);
		}
		
		bk = new int[mm];
		st = new StringTokenizer(f.readLine()); 
		for(int i = 0; i < mm; i++)
		{
			bk[i] = Integer.parseInt(st.nextToken()) - 1;
			// System.out.println("bk=" + bk[i]);
		}
		
	    f.close();    		
	}
	
	public void compute()
	{
		minwt = 0;
		order = new int[nn];
		for(int i = 0; i < nn; i++)
		{
			order[i] = -1;
		}
		
		order[0] = bk[0];
		for(int i = 1; i < mm; i++)
		{
			minwt += process(bk[i]);
		}
	}
	
	private int process(int book)
	{
		int cost = 0;
		boolean b = false;
		int i;
		for(i = 0; i < nn; i++)
		{
			if(order[i] == -1)
				break;
			
			if(order[i] == book)
			{
				b = true;
				break;
			}
		}
		
		if(b)	// book already in list
		{
			if(i == 0)
				return 0;
		}
			
		for(int j = 0; j < i; j++)
		{
			cost += wt[order[i - j - 1]];
			order[i - j] = order[i - j - 1];
		}
		order[0] = book;
		
		return cost;
	}
	

  public static void main (String [] args) throws Exception 
  {
	  nybreading ea = new nybreading();
	  ea.compute();
	  System.out.println("" + ea.minwt);
  }
}
