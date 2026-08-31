import java.util.*;
import java.io.*;

public class practice {

	public static void main(String  [] args) throws Exception
    {Scanner sc = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
   
   
   String pw=sc.nextLine();
   int n =sc.nextInt();
   String[] words =new String[n];
   for(int i =0;i<words.length;i++)
	   words[i]=sc.nextLine();

   StringBuilder x=new StringBuilder();

	
	   for(int j =0;j<n;j++) {
		
		   for(int z=0;z<n;z++) {
			   x.append(words[j]+""+words[z]);
		   } }
	   String y =x.toString();
	  // out.println(y);
	   boolean flag=false;
	   for(int t=0;t<x.length()-1;t++) {String compare=y.charAt(t)+""+y.charAt(t+1);
	   if(compare.equals(pw)){ 
		   flag =true;break;
	   }}
   if(flag)out.println("YES");
   else out.println("NO");
    out.flush();
    }
    static class Scanner
    {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream system) {br = new BufferedReader(new InputStreamReader(system));}
        public Scanner(String file) throws Exception {br = new BufferedReader(new FileReader(file));}
        public String next() throws IOException
        {
            while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }
        public String nextLine()throws IOException{return br.readLine();}
        public int nextInt() throws IOException {return Integer.parseInt(next());}
        public double nextDouble() throws IOException {return Double.parseDouble(next());}
        public char nextChar()throws IOException{return next().charAt(0);}
        public Long nextLong()throws IOException{return Long.parseLong(next());}
        public boolean ready() throws IOException{return br.ready();}
        public void waitForInput() throws InterruptedException {Thread.sleep(3000);}
    }
}
