
import java.io.PrintWriter;

import java.util.*;
import java.util.Arrays ; 

 
import java.io.DataInputStream; 
import java.io.FileInputStream; 
import java.io.IOException; 
import java.lang.reflect.Array;


public class Test{
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
   

static int find(int x[][],int r){
    int sum =0 ;
    
    for (int i = 0; i < x.length; i++) {
        sum+=x[r][i];
    }
    return sum ;
}
static int [] find2(int x[][],int temp,int y[]){
    for (int i = 0; i < x.length; i++) {
        int sum=0 ;
        for (int j = 0; j < x.length; j++) {
           sum+=x[j][i] ;
        }
        y[i]=sum ;
   
    }
   return y;
    
}
static int min(int a ,int b ,int c){
    int x[] ={a,b,c};
    Arrays.sort(x);
    return x[0]-1 ;
}


    public static void main(String[] args) throws IOException  {

    
        PrintWriter pw = new PrintWriter(System.out);   
     Reader  in =new Reader ();
    //  Scanner  in =new Scanner (System.in);
  //   int n= in.nextInt() ; 
     int []x =new int[4] ;
    int r1 =in.nextInt(); int r2 =in.nextInt();
    int c1 =in.nextInt(); int c2 =in.nextInt();
    int d1 =in.nextInt(); int d2 =in.nextInt();
    int a =min(r1,d1,c1),b,c,d; 
   
        for (int i = a; i > 0; i--) {
            b= r1- i;
            c= c1-i ;
            d= d1-i ;
             if(b<=0||c<=0||d<=0){
            continue;
       }
             if(i>9||b>9||c>9||d>9){
                 continue; 
             }
             if(i==b||i==c||i==d||b==c||b==d||d==c){  
               continue; 
             }
            if(b+d==c2&&b+c==d2&&c+d==r2){
                System.out.println(i+" "+b);
                System.out.println(c+" "+d);
                return ;
            }
            
        }
      
        System.out.println("-1");
   
      pw.close(); 
      
            
             
        
      
}
static class pair{
   public  int val , key ; 
    pair(int val , int key){
        this.val= val ; 
        this .key = key   ; 
    }
}
}