import java.io.*;
import java.util.*;

 // Author : Yash Shah

public class D implements Runnable {

    public void run() {
       	
        InputReader sc = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
 
       
            int n=sc.nextInt();
            int k=sc.nextInt();
            ArrayList<ArrayList<Integer>> x = new ArrayList<>();
            
            for(int i=0;i<5;i++)
            x.add(new ArrayList<>());
            
            // 3 - both      1 - bob      2 - alice 

            for(int i=0;i<n;i++)
            {
                int time=sc.nextInt();
                int a=sc.nextInt();
                int b=sc.nextInt();
                //out.println(2*a+b);
                x.get(2*a+b).add(time);
            }

            for(ArrayList<Integer> i:x)
            {
                i.add(0);
                Collections.sort(i);
                for(int j=1;j<i.size();j++)
                {
                    i.set(j,i.get(j-1)+i.get(j));
                }
            }

            long ans=Long.MAX_VALUE;
           

            for(int i=0;i<k+1;i++)
            {
                if(i<x.get(3).size() && k-i<x.get(2).size() && k-i<x.get(1).size())
                {
                    ans=Math.min(ans,x.get(3).get(i)+x.get(1).get(k-i)+x.get(2).get(k-i));
                }
            }

     
            out.println(ans==Long.MAX_VALUE?-1:ans);

        out.close();
    }
 

//========================================================================

	static class Pair
	{
		int a,b;
		Pair(int aa,int bb)
		{
			a=aa;
			b=bb;
		}
	}
	
	static void sa(long a[],InputReader sc,long k)
	{
        
		for(int i=0;i<a.length;i++)
		{
            a[i]=sc.nextInt()%k;
            a[i]=k-a[i];
            a[i]%=k;
		}
        Arrays.sort(a);
	}

	static class PairSort implements Comparator<Pair>
	{
		public int compare(Pair a,Pair b)
		{
			return b.b-a.b;
		}
	}


    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;
        private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        public InputReader(InputStream stream) {
            this.stream = stream;
        }
       
        public int read() {
            if (numChars==-1)
                throw new InputMismatchException();
           
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                }
                catch (IOException e) {
                    throw new InputMismatchException();
                }
               
                if(numChars <= 0)              
                    return -1;
            }
            return buf[curChar++];
        }
     
        public String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
        public int nextInt() {
            int c = read();
           
            while(isSpaceChar(c))
                c = read();
           
            int sgn = 1;
           
            if (c == '-') {
                sgn = -1;
                c = read();
            }
           
            int res = 0;
            do {
                if(c<'0'||c>'9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));
           
            return res * sgn;
        }
       
        public long nextLong() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
           
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));
                return res * sgn;
        }
       
        public double nextDouble() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E')
                    return res * Math.pow(10, nextInt());
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E')
                        return res * Math.pow(10, nextInt());
                    if (c < '0' || c > '9')
                        throw new InputMismatchException();
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
        }
       
        public String readString() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            }
            while (!isSpaceChar(c));
           
            return res.toString();
        }
     
        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
     
        public String next() {
            return readString();
        }
       
        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }

    public static void main(String args[]) throws Exception {
        new Thread(null, new D(),"Main",1<<27).start();
    }
}
