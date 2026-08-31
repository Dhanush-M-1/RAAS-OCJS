import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;



public class Problem2 {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		Scanner sc = new Scanner(inputStream);
		String eqn = sc.nextLine();
		int pls = 1, mns = 0;
		int n = 0 ;
		
		for(int i = 0 ; i < eqn.length(); ++i)
		{
			if(eqn.charAt(i) == '+')
			{
				++pls;
			} else if(eqn.charAt(i) == '-')
			{
				++mns;
			} else if(eqn.charAt(i) == '=')
			{
				String tmp = eqn.substring(i+2, eqn.length());
				n = Integer.parseInt(tmp);
			}
		}
		
		if(n*pls - mns < n || pls - n*mns > n)
		{
			out.println("Impossible");
		}
		else
		{
			out.println("Possible");
			if(pls > n + mns)
			{
				int[] arr2 = new int[mns];
				int sum = pls - n;
				
				while(sum != 0)
				{
					for(int i = 0; i < mns; ++i)
					{
						if(arr2[i] < n)
						{
							arr2[i] += 1;
							sum--;
							if(sum == 0)
							{
								break;
							}
						}
					}
				}
				
				int arrInd = 0;
				out.print(1 + " ");
				for(int i = 2; i < eqn.length(); ++i)
				{
					if(eqn.charAt(i) == '?')
					{
						if(eqn.charAt(i-2) == '+')
						{
							out.print(1);
						}
						else
						{
							out.print(arr2[arrInd]);
							++arrInd;
						}
						
					}
					else
					{
						out.print(eqn.charAt(i));
					}
				}
			}
			else
			{
				int[] arr1 = new int[pls];
				int sum = n + mns;
				int div = sum / pls;
				int rem = sum % pls;
				
				for(int i = 0; i < pls; ++i)
				{
					if( i == pls - 1)
					{
						arr1[i] = div + rem;
						if(arr1[i] > n)
						{
							for(int j = pls-1; j >-1; --j )
							{
								if(arr1[j] < n)
								{
									while(arr1[j] < n)
									{
										arr1[i]--;
										arr1[j]++;
									}
								}
								if(arr1[i] <= n)
								{
									break;
								}
							}
						}
					}
					else
					{
						arr1[i] = div; 
					}
				}
				
				out.print(arr1[0] + " ");
				int arrInd = 1;
				for(int i = 2; i < eqn.length(); ++i)
				{
					if(eqn.charAt(i) == '?')
					{
						if(eqn.charAt(i-2) == '-')
						{
							out.print(1);
						}
						else
						{
							out.print(arr1[arrInd]);
							++arrInd;
						}
						
					}
					else
					{
						out.print(eqn.charAt(i));
					}
				}
			}
		}
		
		
		
		out.close();

	}
	

	
	
	


	
	static class InputReader {
	    public BufferedReader reader;
	    public StringTokenizer tokenizer;

	    public InputReader(InputStream stream) {
	        reader = new BufferedReader(new InputStreamReader(stream), 32768);
	        tokenizer = null;
	    }

	    public String next() {
	        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
	            try {
	                tokenizer = new StringTokenizer(reader.readLine());
	            } catch (IOException e) {
	                throw new RuntimeException(e);
	            }
	        }
	        return tokenizer.nextToken();
	    }

	    public int nextInt() {
	        return Integer.parseInt(next());
	    }
	    
	    public long nextLong()
	    {
	    	return Long.parseLong(next());
	    }

	}


}
