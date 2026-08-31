import java.io.*;
import java.util.*;
import java.nio.charset.StandardCharsets;
// import java.math.BigInteger;

public class B {
    static Writer wr;

    public static void main(String[] args) throws Exception {
        // long startTime = System.nanoTime();

        // String testString = "";
        // InputStream stream = new ByteArrayInputStream(testString.getBytes(StandardCharsets.UTF_8));
        // Reader in = new Reader(stream);

        Reader in = new Reader();
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        
        wr = new Writer();

        /* Precomputation */


        // long elapsedTime = System.nanoTime() - startTime;
        // double seconds = (double)elapsedTime / 1000000000.0;
        // wr.writeRedLn(seconds);

        /* Input */
        int N = in.nextInt();
        String s = in.readLine();

        HashMap<String, Integer> count = new HashMap<>();
        for(int i=0;i<N-1;i++) {
            String x = s.substring(i,i+2);
            if(count.containsKey(x)) {
                count.put(x, count.get(x)+1);
            }
            else {
                count.put(x, 1);
            }
        }

        int max=0;
        String m = "";
        for(HashMap.Entry<String, Integer> e: count.entrySet()) {
            if(e.getValue()>max) {
                max = e.getValue();
                m = e.getKey();
            }
        }


        out.write(m + "\n");
        out.flush();
    }
}



class Writer {
    public void writeRedLn(Object x) { writeRedLn(x+""); }
    public void writeBlueLn(Object x) { writeBlueLn(x+""); }
    public void writeGreenLn(Object x) { writeGreenLn(x+""); }
    public void writePinkLn(Object x) { writePinkLn(x+""); }
    public void writeRedLn(String x) { System.out.println((char)27 + "[31m" + (char)27 + "[40m" + x + (char)27 + "[0m"); }
    public void writeBlueLn(String x) { System.out.println((char)27 + "[34m" + (char)27 + "[3m" + x + (char)27 + "[0m"); }
    public void writeGreenLn(String x) { System.out.println((char)27 + "[32m" + (char)27 + "[3m" + x + (char)27 + "[0m"); }
    public void writePinkLn(String x) { System.out.println((char)27 + "[30m" + (char)27 + "[45m" + x + (char)27 + "[0m"); }
    public void writeRed(String x) { System.out.print((char)27 + "[31m" + (char)27 + "[40m" + x + (char)27 + "[0m"); }
    public void writeBlue(String x) { System.out.print((char)27 + "[34m" + (char)27 + "[3m" + x + (char)27 + "[0m"); }
    public void writeGreen(String x) { System.out.print((char)27 + "[32m" + (char)27 + "[3m" + x + (char)27 + "[0m"); }
    public void writePink(String x) { System.out.print((char)27 + "[30m" + (char)27 + "[45m" + x + (char)27 + "[0m"); }
}


class Reader {
    public int LINE_LIMIT = -1;
    final private int BUFFER_SIZE = 1 << 16;private DataInputStream din;private byte[] buffer;private int bufferPointer, bytesRead;
    public Reader(){din=new DataInputStream(System.in);buffer=new byte[BUFFER_SIZE];bufferPointer=bytesRead=0;}
    public Reader(InputStream stream){din=new DataInputStream(stream);buffer=new byte[BUFFER_SIZE];bufferPointer=bytesRead=0;}
    public int[] ni_array(int N) throws IOException { int[] ans = new int[N]; for(int i=0;i<N;i++) { ans[i] = nextInt(); } return ans; }
    public String readLineUtil()throws IOException{byte[] buf=new byte[Math.max(400024,LINE_LIMIT)];int cnt=0,c;
        while((c=read())!=-1){if(c=='\n')break;buf[cnt++]=(byte)c;}return new String(buf,0,cnt);}
    public String readLine() throws IOException{ String line = readLineUtil().trim(); while(line.length()==0) line = readLineUtil().trim(); return line; }
    public char nextChar()throws IOException{byte c=read();while(c<=' ')c=read();return (char)c;}
    public int nextInt()throws IOException{int ret=0;byte c=read();while(c<=' ')c=read();boolean neg=(c=='-');
        if(neg)c=read();do{ret=ret*10+c-'0';}while((c=read())>='0'&&c<='9');if(neg)return -ret;return ret;} 
    public long nextLong()throws IOException{long ret=0;byte c=read();while(c<=' ')c=read();boolean neg=(c=='-');
        if(neg)c=read();do{ret=ret*10+c-'0';}while((c=read())>='0'&&c<='9');if(neg)return -ret;return ret;}
    public double nextDouble()throws IOException{double ret=0,div=1;byte c=read();while(c<=' ')c=read();boolean neg=(c=='-');if(neg)c = read();do {ret=ret*10+c-'0';}while((c=read())>='0'&&c<='9');
        if(c=='.')while((c=read())>='0'&&c<='9')ret+=(c-'0')/(div*=10);if(neg)return -ret;return ret;}
    private void fillBuffer()throws IOException{bytesRead=din.read(buffer,bufferPointer=0,BUFFER_SIZE);if(bytesRead==-1)buffer[0]=-1;}
    private byte read()throws IOException{if(bufferPointer==bytesRead)fillBuffer();return buffer[bufferPointer++];}
    public void close()throws IOException{if(din==null) return;din.close();}
}
