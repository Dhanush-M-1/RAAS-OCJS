import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Q1 {
    public static void main(String[] args) {
        FasterScanner s = new FasterScanner();
        
       int n=s.nextInt();
       long p[] =new long[n];
       long h[] =new long[n];
       
       for(int i=0;i<n;i++)
       {
           p[i]=s.nextLong();
           h[i]=s.nextLong();
       }
//
       
       
       long p2[]=new long[n];
       long[] c1=new long[n];
       long[] c2=new long[n];
       
       c1[0]=1;
       c2[0]=1;
       p2[0]=p[0]+h[0];
       
       for(int i=1;i<n;i++)
       {
//         System.out.println(i);
//         System.out.println(p[i]+" "+h[i]);
//         System.out.println(c1[i-1]+" "+c2[i-1]+" "+p2[i-1]);
           if(p[i]-h[i]>p2[i-1])
           {
               c1[i]=c2[i-1]+1;
           }
           else if(p[i]-h[i]>p[i-1])
           {
               c1[i]=c1[i-1]+1;
           }
           else if(p[i]>p2[i-1])
               c1[i]=c2[i-1];
           else
               c1[i]=c1[i-1];
           p2[i]=p[i]+h[i];
           if(p[i]>p2[i-1])
               c2[i]=c2[i-1]+1;
           else
               c2[i]=c1[i-1]+1;
       }
       System.out.println(c2[n-1]);
       
       
       
       
       
       
       
       
       
       
       
//       long pointFilled=p[0];
//       for(int i=1;i<n-1;i++)
//       {
//         if(p[i]-h[i]>pointFilled)
//         {
//             count++;
//             pointFilled=p[i];
//         }
//         else if(p[i]+h[i]<p[i+1])
//         {
//             count++;
//             pointFilled=p[i]+h[i];
//         }
//       }
//       if(n!=1)
//         count++;
//       System.out.println(count);
//       
    }

   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static class FasterScanner {
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        public int read() {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = System.in.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public String nextLine() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isEndOfLine(c));
            return res.toString();
        }

        public String nextString() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
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
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }
           
        public int[] nextIntArray(int n) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }
       
        public long[] nextLongArray(int n) {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }
    }
}