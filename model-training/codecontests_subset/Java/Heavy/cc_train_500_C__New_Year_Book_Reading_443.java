import java.io.*;
import java.math.BigInteger;
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
                //String filePath="circles.in";
                String filePath=null;
                if(argv.length>0)filePath=argv[0];
                new A(filePath);
                
        }
        
        public A(String inputFile)
        {
        	Random rgen = new Random();
        	openInput(inputFile);
    		//readNextLine();
    		int n=1;//NextInt();
    		for(int t=0; t<n; t++)
    		{
    			readNextLine();
    			int N=NextInt();
    			int M=NextInt();
    			int [] p = new int[M];
    			int [] w = new int[N];
    			readNextLine();
    			for(int i=0; i<N; i++)
    			{
    				w[i] = NextInt();
    			}
    			readNextLine();
    			for(int i=0; i<M; i++)
    			{
    				p[i] = NextInt();
    			}
    			Stack <Integer> st = new Stack<Integer>();
    			Stack <Integer> tmp = new Stack<Integer>();
    			for(int i=0; i<M; i++)
    			{
    				if(!tmp.contains(p[i]))tmp.push(p[i]);
    			}
    			while(!tmp.isEmpty())
					st.push(tmp.pop());
    			int ret = 0;
    			for(int i=0; i<M; i++)
    			{
    				int now = 0;
    				
    				while(st.peek()!=p[i])
    				{
    					tmp.push(st.pop());
    					//System.out.print(tmp.peek()+" ");
    					now+=w[tmp.peek()-1];
    				}
    				//System.out.println("^");
    				int read = st.pop();
    				while(!tmp.isEmpty())
    					st.push(tmp.pop());
    				st.push(read);
    				
    				ret += now;
    			}
    			System.out.println(ret);
    		}
    		
    		
    		closeInput();		
      
        }


       
}