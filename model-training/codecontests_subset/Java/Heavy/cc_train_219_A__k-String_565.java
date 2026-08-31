import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Kstring {
   public static void main(String[] args) throws IOException {
	Scanner s = new Scanner(System.in);
	int k = s.nextInt();
	String st = s.next();
	if(k==1){
		System.out.println(st);
		return;
	}
	HashMap<Character, Integer> hm = new HashMap<>();
	for (int i = 0; i <st.length(); i++) {
		if(hm.containsKey(st.charAt(i)))
			hm.put(st.charAt(i), hm.get(st.charAt(i))+1);
		else hm.put(st.charAt(i), 1);
	}
	for(char v: hm.keySet())
		if(hm.get(v)%k !=0){
			System.out.println(-1);
			return;
		}
	StringBuilder out=new StringBuilder();
	for(char v: hm.keySet()){
		int x = hm.get(v)/k;
		while(x-- >0)
			out.append(v+"");
		
	}
	StringBuilder f = new StringBuilder();
	while(k-- >0)
		f.append(out);
	System.out.println(f);
}
   static class Scanner {
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
