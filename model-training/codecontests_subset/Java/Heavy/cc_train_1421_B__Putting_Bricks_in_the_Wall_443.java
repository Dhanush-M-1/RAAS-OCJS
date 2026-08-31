import java.util.*;
import java.util.Scanner;
import java.io.*;
import javax.lang.model.util.ElementScanner6; 
import static java.lang.System.out;


public class B1421
{

   
    
    public static void main(String args[])
    {  

        FastReader in=new FastReader();
        PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int tc=1;
     
        tc=in.nextInt();
        while(tc-->0)
        {
            
        	int n=in.nextInt();
        	
        	char arr[][]=new char[n][n];
        	for(int i=0;i<+n;i++)
        	{
				String S=in.nextLine();
				arr[i]=S.toCharArray();
				
			}
			
			int xtop=((arr[1][0]-'0')^(arr[0][1]-'0'));
			
			int xbot=((arr[n-2][n-1]-'0')^(arr[n-1][n-2]-'0'));
			
			if(xtop==xbot)
			{
				if(xtop==0)
				{
					if(arr[1][0]==arr[n-1][n-2])
					{
						pr.println(2);
						pr.println(1+" "+2);
						pr.println(2+" "+1);
					}
					else pr.println(0);
				}
				else
				{
					pr.println(2);
					if(arr[1][0]=='1')
					{	
						pr.println(2+" "+1);
					}
					else pr.println(1+" "+2);
					
					if(arr[n-1][n-2]=='0')
					{
						pr.println(n+" "+(n-1));
					}
					else pr.println(n-1+" "+n);	
					
					
					
					
				}
			}
			else
			{
				pr.println(1);
				if(xtop==1)
				{
					if(((arr[1][0]-'0')^(arr[n-2][n-1]-'0'))==0)
					{
						pr.println(2+" "+1);
					}
					else pr.println(1+" "+2);
					
				}
				else
				{
					if(((arr[1][0]-'0')^(arr[n-2][n-1]-'0'))==0)
					{
						pr.println((n-1)+" "+(n));
					}
					else pr.println(n+" "+(n-1));
					
				}
				
				
			}
			
        	
        	

        



        }
        pr.flush();
        
    }


    

    static void sort(long[] a) {
		ArrayList<Long> l = new ArrayList<>();
		for (long i : a)
			l.add(i);
		Collections.sort(l);
		for (int i = 0; i < a.length; i++)
			a[i] = l.get(i);
	}
    
    
	static void sort(int[] a) {
		ArrayList<Integer> l = new ArrayList<>();
		for (int i : a)
			l.add(i);
		Collections.sort(l);
		for (int i = 0; i < a.length; i++)
			a[i] = l.get(i);
    }

    
    static class FastReader
    { 
        BufferedReader br; 
        StringTokenizer st; 

        public FastReader() 
        { 
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 

        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 

        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 

        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 

        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 

        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    } 
}
