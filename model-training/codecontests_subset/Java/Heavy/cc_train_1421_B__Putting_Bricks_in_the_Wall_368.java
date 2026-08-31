import java.util.*;
import java.io.*;
public class Main
{
    static class Reader 
    { 
        final private int BUFFER_SIZE = 1 << 16; 
        private DataInputStream din; 
        private byte[] buffer; 
        private int bufferPointer, bytesRead; 
  
        public Reader() 
        { 
            din = new DataInputStream(System.in); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 
  
        public Reader(String file_name) throws IOException 
        { 
            din = new DataInputStream(new FileInputStream(file_name)); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 
  
        public String readLine() throws IOException 
        { 
            byte[] buf = new byte[64]; // line length 
            int cnt = 0, c; 
            while ((c = read()) != -1) 
            { 
                if (c == '\n') 
                    break; 
                buf[cnt++] = (byte) c; 
            } 
            return new String(buf, 0, cnt); 
        } 
  
        public int nextInt() throws IOException 
        { 
            int ret = 0; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
            do
            { 
                ret = ret * 10 + c - '0'; 
            }  while ((c = read()) >= '0' && c <= '9'); 
  
            if (neg) 
                return -ret; 
            return ret; 
        } 
  
        public long nextLong() throws IOException 
        { 
            long ret = 0; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
            do { 
                ret = ret * 10 + c - '0'; 
            } 
            while ((c = read()) >= '0' && c <= '9'); 
            if (neg) 
                return -ret; 
            return ret; 
        } 
  
        public double nextDouble() throws IOException 
        { 
            double ret = 0, div = 1; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
  
            do { 
                ret = ret * 10 + c - '0'; 
            } 
            while ((c = read()) >= '0' && c <= '9'); 
  
            if (c == '.') 
            { 
                while ((c = read()) >= '0' && c <= '9') 
                { 
                    ret += (c - '0') / (div *= 10); 
                } 
            } 
  
            if (neg) 
                return -ret; 
            return ret; 
        } 
  
        private void fillBuffer() throws IOException 
        { 
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE); 
            if (bytesRead == -1) 
                buffer[0] = -1; 
        } 
  
        private byte read() throws IOException 
        { 
            if (bufferPointer == bytesRead) 
                fillBuffer(); 
            return buffer[bufferPointer++]; 
        } 
  
        public void close() throws IOException 
        { 
            if (din == null) 
                return; 
            din.close(); 
        } 
    } 
    public static void main(String args[])throws Exception
    {
        Reader sc=new Reader();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        int t=Integer.parseInt(br.readLine());//sc.nextInt();
        while(t-->0)
        {
            int n=Integer.parseInt(br.readLine());
            char carr[][]=new char[n][n];
            for(int i=0;i<n;i++)
            carr[i]=br.readLine().toCharArray();
            ArrayList<String> list=new ArrayList<>();
            if(carr[0][1]==carr[1][0])
            {
                
                if(carr[n-2][n-1]==carr[0][1])
                list.add((n-1)+" "+n);
                if(carr[n-1][n-2]==carr[0][1])
                list.add(n+" "+(n-1));
                pw.println(list.size());
                for(String s:list)
                pw.println(s);
            }
            else if(carr[n-1][n-2]==carr[n-2][n-1])
            {
                if(carr[n-2][n-1]==carr[0][1])
                list.add(1+" "+2);
                if(carr[n-1][n-2]==carr[1][0])
                list.add(2+" "+1);
                pw.println(list.size());
                for(String s:list)
                pw.println(s);
            }
            else
            {
                if(carr[n-2][n-1]!='1')
                list.add((n-1)+" "+n);
                if(carr[n-1][n-2]!='1')
                list.add(n+" "+(n-1));
                if(carr[0][1]!='0')
                list.add(1+" "+2);
                if(carr[1][0]!='0')
                list.add(2+" "+1);
                pw.println(list.size());
                for(String s:list)
                pw.println(s);
            }
        }
        pw.flush();
        pw.close();
    }
}