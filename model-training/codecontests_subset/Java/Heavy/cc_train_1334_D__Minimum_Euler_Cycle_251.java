import java.util.*;
import java.io.*;
import static java.lang.Math.*;
import static java.lang.System.*;
public class D
{
    public static void main(String[]args){
        InputReader sc = new InputReader(System.in);
        PrintWriter pw =new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int cases=sc.nextInt();
        for(int z=0;z<cases;z++){
        	int len=sc.nextInt();
        	long begin=sc.nextLong();
        	long end=sc.nextLong();
        	begin-=2;
        	end-=2;
        	ArrayList<Integer>nodes=new ArrayList<Integer>();
        	if(begin==-1){
        		nodes.add(1);
        		begin++;
        		end++;
        	}
        	long[]cycle=new long[len-1];
        	long[]intecycle=new long[len-1];
        	for(int i=0;i<cycle.length;i++){
        		cycle[i]=(len-i-1)*2;
        	}
        	for(int i=0;i<intecycle.length;i++){
        		intecycle[i]+=cycle[i];
        		if(i!=0)intecycle[i]+=intecycle[i-1];
        	}
        	int begincycle=0;
        	while(begincycle<len&&begin>intecycle[begincycle])begincycle++;
        	if(begincycle!=0){
        		begin-=intecycle[begincycle-1];
        		end-=intecycle[begincycle-1];
        	}
        	long duration=end-begin+1;
        	for(int a=begincycle;a<len&&nodes.size()<200005;a++){
        		if(a==len-2){
        			nodes.add(len);
        			nodes.add(1);
        			break;
        		}
        		for(int b=a+1;b<len;b++){
        			nodes.add(b+1);
        			if(b!=len-1)nodes.add(a+1);
        			else nodes.add(a+2);
        		}
        	}
        	System.out.print(nodes.get((int)begin));
        	for(int a=(int)begin+1;a<begin+duration;a++){
        		System.out.print(" "+nodes.get(a));
        	}
        	System.out.println();
        }
        
        pw.flush();
    }
    
    static class InputReader
    {
        private final InputStream stream;
        private final byte[] buf = new byte[8192];
        private int curChar, snumChars;
        private SpaceCharFilter filter;
        public InputReader(InputStream stream)
        {
                this.stream = stream;
        }
        public int snext()
        {
                if (snumChars == -1)
                        throw new InputMismatchException();
                if (curChar >= snumChars)
                {
                        curChar = 0;
                        try
                        {
                                snumChars = stream.read(buf);
                        } catch (IOException e)
                        {
                                throw new InputMismatchException();
                        }
                        if (snumChars <= 0)
                                return -1;
                }
                return buf[curChar++];
        }
        public int nextInt()
        {
                int c = snext();
                while (isSpaceChar(c))
                {
                        c = snext();
                }
                int sgn = 1;
                if (c == '-')
                {
                        sgn = -1;
                        c = snext();
                }
                int res = 0;
                do
                {
                        if (c < '0' || c > '9')
                                throw new InputMismatchException();
                        res *= 10;
                        res += c - '0';
                        c = snext();
                } while (!isSpaceChar(c));
                return res * sgn;
        }
        public long nextLong()
        {
                int c = snext();
                while (isSpaceChar(c))
                {
                        c = snext();
                }
                int sgn = 1;
                if (c == '-')
                {
                        sgn = -1;
                        c = snext();
                }
                long res = 0;
                do
                {
                        if (c < '0' || c > '9')
                                throw new InputMismatchException();
                        res *= 10;
                        res += c - '0';
                        c = snext();
                } while (!isSpaceChar(c));
                return res * sgn;
        }
        public double nextDouble()
        {
                int c = snext();
                while (isSpaceChar(c))
                {
                        c = snext();
                }
                int sgn = 1;
                if (c == '-')
                {
                        sgn = -1;
                        c = snext();
                }
                double res = 0;
                while(c<='9'&&c>='0'){
                    res*=10;
                    res+=c-'0';
                    c=snext();
                }
                if(c=='.'){
                    double decimal=0;
                    long multiplier=1;
                    c=snext();
                    do
                    {
                        if (c < '0' || c > '9')
                                throw new InputMismatchException();
                        decimal *= 10;
                        decimal += c - '0';
                        multiplier*=10;
                        c = snext();
                    } while (!isSpaceChar(c));
                    return sgn*(res+decimal/multiplier);
                }else{
                    if(!isSpaceChar(c)){
                        throw new InputMismatchException();
                    }
                    return sgn*res;
                }
        }
        public int[] nextIntArray(int n)
        {
                int a[] = new int[n];
                for (int i = 0; i < n; i++)
                {
                        a[i] = nextInt();
                }
                return a;
        }
        public long[] nextLongArray(int n)
        {
                long a[] = new long[n];
                for (int i = 0; i < n; i++)
                {
                        a[i] = nextLong();
                }
                return a;
        }
        public String next(){return readString();}
        public String readString()
        {
                int c = snext();
                while (isSpaceChar(c))
                {
                        c = snext();
                }
                StringBuilder res = new StringBuilder();
                do
                {
                        res.appendCodePoint(c);
                        c = snext();
                } while (!isSpaceChar(c));
                return res.toString();
        }
        public String nextLine()
        {
                int c = snext();
                StringBuilder res = new StringBuilder();
                do
                {
                        res.appendCodePoint(c);
                        c = snext();
                } while (!isEndOfLine(c));
                if(isEndOfLine(res.charAt(res.length()-1)))
                return res.deleteCharAt(res.length()).toString();
                return res.toString();
        }
        public ArrayList<String> readAll(){
            ArrayList<String>a=new ArrayList<String>();
            try{
                while(true){
                    a.add(nextLine());
                }
            }catch(Exception e){
                
            }
            return a;
        }
        public boolean hasNext(){
            boolean hasnext=true;
            try{
                hasnext= stream.available()!=0;
            }catch(IOException e){
            }
            return hasnext||curChar<snumChars;
        }
        public boolean isSpaceChar(int c)
        {
                if (filter != null)
                        return filter.isSpaceChar(c);
                return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
        private boolean isEndOfLine(int c)
        {
                return c == '\n' || c == '\r' || c == -1;
        }
        public interface SpaceCharFilter
        {
                public boolean isSpaceChar(int ch);
        }
    }
}