import java.io.DataInputStream; 
import java.io.FileInputStream; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.*; 

public class HelloWorld{

     public static void main(String []args) throws IOException{
        Reader sc=new Reader();
        int n=sc.nextInt(),k=sc.nextInt(),A=0,B=0;
        int t[]=new int[n],a[]=new int[n],b[]=new int[n];
        ArrayList<Long> sum[]=new ArrayList[4],times[]=new ArrayList[4];
        for(int i=0;i<4;i++){
            sum[i]=new ArrayList<Long>();
            times[i]=new ArrayList<Long>();
            sum[i].add(0l);
        }
        for(int i=0;i<n;i++){
            t[i]=sc.nextInt();
            a[i]=sc.nextInt();
            b[i]=sc.nextInt();
            A+=a[i];
            B+=b[i];
            int pos=a[i]*2+b[i];
            times[pos].add(t[i]+0l);
        }
        
        if(A<k||B<k){
            System.out.println("-1");
            return;
        }
        
        for(int i=0;i<4;i++){
            Collections.sort(times[i]);
            for(int j=0;j<times[i].size();j++){
                long lastEle=sum[i].get(sum[i].size()-1);
                sum[i].add(times[i].get(j)+lastEle);
            }
        }
        
        
        long ans=Integer.MAX_VALUE;
        for(int count=0;count<Integer.min(k+1,sum[3].size());count++){
            int req=k-count;
            if(req<sum[1].size()&&req<sum[2].size()){
                ans=Math.min(ans,sum[3].get(count)+sum[1].get(req)+sum[2].get(req));
            }
        }
        System.out.println(ans);
     }
}

class Reader 
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