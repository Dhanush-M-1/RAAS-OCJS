import java.io.*;
import java.util.*;


public class div3c {

    public static void main(String[] args) throws Exception{
        Reader fs = new Reader();
        int T = 1;
       
        T=fs.nextInt();
        for (int tt = 0; tt < T; tt++) {
        	
        	String s= fs.readLine();
        	int k = fs.nextInt();
        	int n = fs.nextInt();
        	int m= fs.nextInt();
        	int a[] = new int[n+m];
        	int b[]= new int[m];
        	
        	for(int i=0;i<n;i++){
        		a[i]=fs.nextInt(); 
        		
        	}
        	for(int i=0;i<m;i++){
        		b[i]=fs.nextInt();
        	}
        	int j=0;int kk=0;
        	int ans[] = new int[n+m];
        	int p=0;
        	for(int i=0;i<(n+m);i++){
                  // System.out.println(j +" "+kk);
        		if(j>=n){
        			
        			break;
        		}
        		if(kk>=m){
        			p=i;
        			break;
        		}
        		if(a[j]<=b[kk]){
        			ans[i]=a[j];
        			p+=1;
        			j+=1;
        		}else{
        			ans[i]=b[kk];
        			kk+=1;
        			p+=1;
        		}
        	}
        	for(int l=j;l<n;l++){
        		ans[p]=a[l];
        		p+=1;
        	}
        	        	for(int l=kk;l<m;l++){
        		ans[p]=b[l];
        		p+=1;
        	}
        	StringBuilder sb = new StringBuilder();
        	int zero=0;
        	boolean answer=true;
        	for(int i:ans){
                 if(i==0){
                 	zero+=1;
                 	sb.append(i+" ");
                 	continue;
                 }
                 if(zero+k<i){
                 	answer =false;
                 	break;
                 }
                 sb.append(i+" " );
        		
        	}
        	if(answer){
        		System.out.println(sb.toString());
        	}else{
        		System.out.println(-1);
        	}

        

        	
        }
    }

    static void sort(int[] a) {
        ArrayList<Integer> l = new ArrayList<>();
        for (int i : a) l.add(i);
        Collections.sort(l);
        for (int i = 0; i < a.length; i++) a[i] = l.get(i);
    }

    static class Reader {
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
            din = new DataInputStream(
                new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    }
                    else {
                        continue;
                    }
                }
                buf[cnt++] = (byte)c;
            }
            return new String(buf, 0, cnt);
        }
 
        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
 
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
            } while ((c = read()) >= '0' && c <= '9');
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
            } while ((c = read()) >= '0' && c <= '9');
 
            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }
 
            if (neg)
                return -ret;
            return ret;
        }
 
        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0,
                                 BUFFER_SIZE);
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
 

}