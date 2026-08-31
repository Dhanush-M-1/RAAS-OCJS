import java.io.*;
import java.util.*;

import javax.print.DocFlavor;

public class Main {
   private static IO io;

   public static void main(String[] args) throws IOException {
       new Main().run();
   }

   private void run() throws IOException {
       io = new IO(System.getProperty("ONLINE_JUDGE")!=null);//false->files; true->console
       solve();
       io.flush();
   }

   private void solve() throws IOException {
       int n = io.nI(), x = io.nI(), y = io.nI();
       if(1.0*x/n>y/100.)io.wln(0);else
           io.wln((int)(y*n/100.0+0.9999999)-x);
   }//2.2250738585072012e-308
   
   @SuppressWarnings("unused")
   private class IO{
       StreamTokenizer in; PrintWriter out; BufferedReader br; Reader reader; Writer writer;
       public IO(boolean oj) throws IOException{
           Locale.setDefault(Locale.US);
           reader = oj ? new InputStreamReader(System.in) : new FileReader("input.txt");
           writer = oj ? new OutputStreamWriter(System.out) : new FileWriter("output.txt");
           br = new BufferedReader(reader);
           in = new StreamTokenizer(br);
           out = new PrintWriter(writer);
       }
       public void wln(){out.println();}
       public void wln(int arg){out.println(arg);}
       public void wln(long arg){out.println(arg);}
       public void wln(double arg){out.println(arg);}
       public void wln(String arg){out.println(arg);}
       public void wln(boolean arg){out.println(arg);}
       public void wln(char arg){out.println(arg);}
       public void wln(float arg){out.println(arg);}
       public void wln(Object arg){out.println(arg);}
       public void w(int arg){out.print(arg);}
       public void w(long arg){out.print(arg);}
       public void w(double arg){out.print(arg);}
       public void w(String arg){out.print(arg);}
       public void w(boolean arg){out.print(arg);}
       public void w(char arg){out.print(arg);}
       public void w(float arg){out.print(arg);}
       public void w(Object arg){out.print(arg);}
       public void wf(String format, Object...args){out.printf(format, args);}
       public void flush(){out.flush();}
       public int nI() throws IOException {in.nextToken(); return(int)in.nval;}
       public long nL() throws IOException {in.nextToken(); return(long)in.nval;}
       public String nS() throws IOException {in.nextToken(); return in.sval;}
       public double nD() throws IOException {in.nextToken(); return in.nval;}
       public float nF() throws IOException {in.nextToken(); return (float)in.nval;}
       public void wc(char...a){for(char c : a){in.ordinaryChar(c);in.wordChars(c, c);}}
       public void wc(char c1, char c2){in.ordinaryChars(c1, c2); in.wordChars(c1, c2);}
   }
}