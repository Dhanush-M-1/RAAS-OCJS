import java.io.*;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.*;

public class A
{
	String line;
	StringTokenizer inputParser;
	BufferedReader is;
	FileInputStream fstream;
	DataInputStream in;
	String FInput="";
	
	void openInput(String file)
	{

		if(file==null)is = new BufferedReader(new InputStreamReader(System.in));//stdin
		else
		{
			try{
			fstream = new FileInputStream(file);
			in = new DataInputStream(fstream);
			is = new BufferedReader(new InputStreamReader(in));
			}catch(Exception e)
			{
				System.err.println(e);
			}
		}

	}
	
	void readNextLine()
	{
		try {
			line = is.readLine();
			inputParser = new StringTokenizer(line, " ");
			//System.err.println("Input: " + line);
		} catch (IOException e) {
			System.err.println("Unexpected IO ERROR: " + e);
		}	
		catch (NullPointerException e)
		{
			line=null;
			
		}
		
	}
	
	int NextInt()
	{
		String n = inputParser.nextToken();
		int val = Integer.parseInt(n);
		
		//System.out.println("I read this number: " + val);
		return val;
	}
	
	long NextLong()
	{
		String n = inputParser.nextToken();
		long val = Long.parseLong(n);
		
		//System.out.println("I read this number: " + val);
		return val;
	}
	
	double NextDouble()
	{
		String n = inputParser.nextToken();
		double val = Double.parseDouble(n);
		
		//System.out.println("I read this number: " + val);
		return val;
	}
	
	String NextString()
	{
		String n = inputParser.nextToken();
		return n;
	}
	
	void closeInput()
	{
		try {
			is.close();
		} catch (IOException e) {
			System.err.println("Unexpected IO ERROR: " + e);
		}
			
	}
	
	
	public static void main(String [] argv)
	{
		//String filePath="input.txt";
        String filePath=null;
		if(argv.length>0)filePath=argv[0];
		new A(filePath);
	}
	Random rand;
	public A(String inputFile)
	{
		rand = new Random();
		openInput(inputFile);
		StringBuilder sb = new StringBuilder();
		readNextLine();
    	int N=NextInt();
    	int M=NextInt();
    	int [] t = new int[M];
    	int [] L = new int[M];
    	int [] R = new int[M];
    	int [] D = new int[M];
    	
    	for(int m=0; m<M; m++)
    	{
    		readNextLine();
    		t[m]=NextInt();
    		L[m]=NextInt()-1;
    		R[m]=NextInt()-1;
    		D[m]=NextInt();
    	}
    	
    	int [] p = new int [N];
    	for(int i=0; i<N; i++)
    		p[i]=100000007;
    	boolean poss=true;
    	for(int m=M-1; m>=0; m--)
    	{
    		if(t[m]==2)
    		{
    			//poss=false;
	    		for(int i=L[m]; i<=R[m]; i++)
	    		{
	    			//if(p[i]>=D[m])poss=true;
	    			p[i]=Math.min(p[i], D[m]);
	    		}
	    		//if(!poss)break;
    		}
    		else
    		{
    			for(int i=L[m]; i<=R[m]; i++)
    				p[i]-=D[m];
    		}
    	}
    	if(poss)
    	{
    		int [] q = new int[N];
    		for(int i=0; i<N; i++)
    			q[i]=p[i];
    		for(int m=0; m<M&&poss; m++)
    		{
    			if(t[m]==2)
        		{
        			int max=Integer.MIN_VALUE;
    	    		for(int i=L[m]; i<=R[m]; i++)
    	    		{
    	    			max=Math.max(max, q[i]);
    	    		}
    	    		if(max!=D[m]){poss=false;break;}
        		}
        		else
        		{
        			for(int i=L[m]; i<=R[m]; i++)
        				q[i]+=D[m];
        		}
    		}
    		if(poss)
    		{
	    		sb.append("YES\n");
	    		for(int i=0; i<N; i++)
	    			sb.append(p[i]+" ");
	    		sb.append("\n");
    		}
    	}
    	if(!poss)sb.append("NO");
    	System.out.print(sb);
		closeInput();				
	}

	
	
}