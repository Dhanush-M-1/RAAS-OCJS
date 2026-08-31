import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;


public class B
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
    			inputParser = new StringTokenizer(line, " ,\t");
    			//System.err.println("Input: " + line);
    		} catch (IOException e) {
    			System.err.println("Unexpected IO ERROR: " + e);
    		}	
    		catch (NullPointerException e)
    		{
    			line=null;
    			
    		}
    		
    	}
        
        long NextLong()
        {
                String n = inputParser.nextToken();
                
                long val = Long.parseLong(n);
                
                 return val;
        }
        
        int NextInt()
        {
                String n = inputParser.nextToken();
                int val = Integer.parseInt(n);
                
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
        		//String filePath="D:\\_d\\learn\\coursera\\algorithms and design I\\data\\HashInt.txt";
                String filePath=null;
                if(argv.length>0)filePath=argv[0];
                new B(filePath);
                
        }
        
        public void readFInput()
    	{
    		for(;;)
    		{
    			try
    			{
    				readNextLine();
    				FInput+=line+" ";
    			}
    			catch(Exception e)
    			{
    				break;
    			}
    		}
    		inputParser = new StringTokenizer(FInput, " ");
    	}
        
        
        public B(String inputFile)
        {
        	openInput(inputFile);
    		readNextLine();
    		int N=NextInt(), X=NextInt()-1;
    		int [] a = new int[N];
    		int [] b = new int[N];
    		Arrays.fill(b, -1);
    		readNextLine();
    		for(int i=0; i<N; i++)
    		{
    			a[i]=NextInt()-1;
    			if(a[i]>-1)b[a[i]]=i;
    		}
    		boolean [] p = new boolean[N];
    		for(int i=0; i<N; i++)
    		{
    			if(a[i]>=0)p[a[i]]=true;
    		}
    		ArrayList <Integer> poss = new ArrayList<Integer>();
    		int cnt=0;
    		for(int i=0; i<N; i++)
    		{
    			if(a[i]>-1)continue;
    			int id=i;
    			int bid=id;
    			while(p[id])
    			{
    				id=b[id];
    				cnt++;
    			}
    			poss.add(cnt+1);
    			cnt=0;
    		}
    		
    		int id=X;
    		int myPoss=1;
    		cnt=1;
    		while(a[id]>-1)
    		{
    			myPoss++;
    			id=a[id];
    			cnt++;
    		}
    		id=X;
    		while(b[id]>-1)
    		{
    			id=b[id];
    			cnt++;
    		}
    		poss.remove((Integer)cnt);
    		
    		
    		boolean [] s = new boolean[N];
    		
    		for(int i=0; i<poss.size(); i++)
    		{
    			int now=poss.get(i);
    			for(int j=N-1; j>=0; j--)
    				if(s[j])s[j+now]=true;
    			s[now]=true;
    		}
    		StringBuilder sb=new StringBuilder();
    		sb.append(myPoss+"\n");
    		for(int i=0; i<N; i++)
    		{
    			if(s[i])sb.append((i+myPoss)+"\n");	
    		}
    	    System.out.println(sb);
    		closeInput();
    	}
        
        
       
}