import java.io.*;
import java.math.BigInteger;
import java.util.*;
import static java.lang.Integer.parseInt;

public class solution {
	
    public static void main (String[] args) throws IOException{
    	FastReader f=new FastReader();
    	PrintWriter out = new PrintWriter(System.out);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printWriter = new PrintWriter(System.out);

        int n = parseInt(in.readLine());

        int[][] g = new int[n][n];

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int j = 0;
            for (char c : in.readLine().toCharArray()) {

                int z = Character.digit(c, 16);
                String s = Integer.toBinaryString(z);
                StringBuilder stringBuilder1 = new StringBuilder(s);

                if (s.length() == 3) {
                    stringBuilder1.insert(0, "0");
                } else if (s.length() == 2) {
                    stringBuilder1.insert(0, "00");
                } else if (s.length() == 1) {
                    stringBuilder1.insert(0, "000");
                }

                for (char ch : stringBuilder1.toString().toCharArray()) {
                    g[i][j] = Character.digit(ch, 10);
                    j++;
                }
            }
        }
    	
    	int[][] sums = new int[n][n];
    	sums[0][0] = g[0][0];
    	for (int i=1;i<n;i++) {
    		sums[0][i] = sums[0][i-1]+g[0][i];
    		sums[i][0] = sums[i-1][0]+g[i][0];
    	}
    	for (int i=1;i<n;i++) {
    		for (int j=1;j<n;j++) {
    			sums[i][j] = sums[i-1][j] + sums[i][j-1] - sums[i-1][j-1] + g[i][j];
    		}
    	}
    	ArrayList<Integer> bs = new ArrayList<>();
    	
    	for (int i=2;i<=n;i++) {
    		if (n%i==0) bs.add(i);
    	}
    	
    	for (int i=bs.size()-1;i>=0;i--) {
    		if (helper(g,bs.get(i),sums)==true) {
    			System.out.println(bs.get(i));
    			return;
    		}
    	}
    	
    	System.out.println(1);
    	
    }
    
    static boolean helper(int[][] g, int k,int[][] sums) {
    	
    	for (int i=0;i<g.length;i+=k) {
    		for (int j=0;j<g.length;j+=k) {
    			if (!issame(g,i,j,k,sums)) return false;
    		}
    	}
    	return true;
    }
    
    private static boolean issame(int[][] g,int rows, int cols,int k,int[][] sums) {
    	int y = g[rows][cols];
    	int a= sums[rows-1+k][cols-1+k];
    	
    	int b= 0;
    	if (cols-1>=0) b = sums[rows-1+k][cols-1];
    	
    	int c= 0;
    	if (rows-1>=0) c= sums[rows-1][cols-1+k];
    	
    	int d = 0;
    	if (rows-1>=0 && cols-1>=0) d = sums[rows-1][cols-1];
    	
    	int sum = a - b - c + d;
    	
    	if (y==0) {
    		if (sum==0) return true;
    		else return false;
    	}
    	if (sum==k*k) return true;
    	return false;
	}

	static String hexToBin(String s) {
    	  return new BigInteger(s, 16).toString(2);
    }

    static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
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