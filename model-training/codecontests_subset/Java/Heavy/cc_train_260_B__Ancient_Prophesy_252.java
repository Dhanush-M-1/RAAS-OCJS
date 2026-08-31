import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class R158_Div2_B
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new R158_Div2_B().run();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	void solve()
	{
		String s = in.next();
        int n = s.length();
        int max = 0;
        String maxDate = "";
        HashMap<String, Integer> hm = new HashMap<String, Integer>();

        for (int i = 0; i <= n - 10; i++)
        {
            String df = s.substring(i, i + 10);
            if (IsValidDate(df))
            {
            	int priorVal = 0;
                if (hm.containsKey(df))
                	priorVal = hm.get(df);
                hm.put(df,  priorVal + 1);    
//                if (priorVal + 1 > max)
//                {
//                	max = priorVal + 1;
//                	maxDate = df;
//                }
            }
        }

        for (String key : hm.keySet())
            if (hm.get(key) > max)
            {
                max = hm.get(key);
                maxDate = key;
            }
		
		out.println(maxDate);		
	}
	
	static int [] DaysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
    static boolean IsValidDate(String dt)
    {
        for (int i = 0; i <= 9; i++)
            if (i == 2 || i == 5)
            {
                if (dt.charAt(i) != '-') return false;  // dt[i] is digit
            }
            else
            {
                if (dt.charAt(i) == '-') return false;  //(dt[i] < '0' || dt[i] > '9')
            }

        String[] s = dt.split("-");
        int d = Integer.parseInt(s[0]); //dt.Substring(0, 2);
        int m = Integer.parseInt(s[1]); //dt.Substring(3, 2);
        int y = Integer.parseInt(s[2]); //dt.Substring(6, 4);
        if (y < 2013 || y > 2015) return false;
        if (m < 1 || m > 12) return false;
        
        //Create a calendar object and set year and month
        //Calendar mycal = new GregorianCalendar(y, m, 1);
        //Get the number of days in that month
        //int daysInMonth = mycal.getActualMaximum(Calendar.DAY_OF_MONTH); 
        
        //if (d < 1 || d > daysInMonth) return false;
        if (d < 1 || d > DaysInMonth[m-1]) return false;
        return true;
    }

	//-----------------------------------------------------
	void runWithFiles() {
		in = new FastReader(new File("input.txt"));
		try {
			out = new PrintWriter(new File("output.txt"));
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		solve();
		out.close();
	}
	
	class FastReader
	{
	    BufferedReader br;
	    StringTokenizer tokenizer;
	    
	    public FastReader(InputStream stream)
	    {
	        br = new BufferedReader(new InputStreamReader(stream));
	        tokenizer = null;
	    }
		public FastReader(File f) {
			try {
				br = new BufferedReader(new FileReader(f));
				tokenizer = null;
			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	    
	    private String next() {
	        while (tokenizer == null || !tokenizer.hasMoreTokens())
	            try {
	            	tokenizer = new StringTokenizer(br.readLine());
	            }
	            catch (IOException e) {
	                throw new RuntimeException(e);
	            }
	        return tokenizer.nextToken();
	    }
		public String nextLine() {
			try	{
				return br.readLine();
			}
			catch(Exception e) {
				throw(new RuntimeException());
			}
		}

	    int nextInt() {
	        return Integer.parseInt(next());
	    }
	    long nextLong() {
	        return Long.parseLong(next());
	    }
	    double nextDouble() {
	        return Double.parseDouble(next());
	    }	    
	    BigInteger nextBigInteger() {
	        return new BigInteger(next());
	    }
	    BigDecimal nextBigDecimal() {
	        return new BigDecimal(next());
	    }
	}
}
