import java.io.*;
import java.util.StringTokenizer;

public class initialbet {

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw=new PrintWriter(System.out);
        int c1=sc.nextInt();
        int c2=sc.nextInt();
        int c3=sc.nextInt();
        int c4=sc.nextInt();
        int c5=sc.nextInt();
        int sum=c1+c2+c3+c4+c5;
        if(sum%5!=0)
        	pw.println(-1);
        else {
        	if(sum==0)
        		pw.println(-1);
        	else
        		pw.println(sum/5);
        }
        pw.flush();
    }

    static class Scanner
    {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream system) {br = new BufferedReader(new InputStreamReader(system));}
        public String next() throws IOException
        {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }
        public String nextLine()throws IOException{return br.readLine();}
        public int nextInt() throws IOException {return Integer.parseInt(next());}
        public double nextDouble() throws IOException {return Double.parseDouble(next());}
        public char nextChar()throws IOException{return next().charAt(0);}
        public Long nextLong()throws IOException{return Long.parseLong(next());}
        public boolean ready() throws IOException{return br.ready();}
        public void waitForInput() throws InterruptedException {Thread.sleep(4000);}
    }

}