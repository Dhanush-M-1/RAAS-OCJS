import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class B {
	
	static class Scanner{
		BufferedReader br=null;
		StringTokenizer tk=null;
		public Scanner(){
			br=new BufferedReader(new InputStreamReader(System.in));
		}
		public String next() throws IOException{
			while(tk==null || !tk.hasMoreTokens())
				tk=new StringTokenizer(br.readLine());
			return tk.nextToken();
		}
		public int nextInt() throws NumberFormatException, IOException{
			return Integer.valueOf(next());
		}
		public double nextDouble() throws NumberFormatException, IOException{
			return Double.valueOf(next());
		}
	}
	
	static boolean isdigit(char a){
		return (a>='0' && a<='9');
	}
	
	
	
	static int getnumber(int from,int to,char[] s){
		int ret=0;
		for(int i=from;i<to;i++){
			ret*=10;
			ret+=s[i] - '0';
		}
		return ret;
	}
	
	static boolean isadate(char[] s,int index){
		if (index+9>=s.length)
			return false;
		boolean d=isdigit(s[index]) && isdigit(s[index+1]) && s[index+2]=='-';
		boolean m=isdigit(s[index+3]) && isdigit(s[index+4]) && s[index+5]=='-';
		boolean y=isdigit(s[index+6]) && isdigit(s[index+7]) && isdigit(s[index+8]) && isdigit(s[index+9]);
		return d && m && y;
	}
	
	static int[] meses={31,28,31,30,31,30,31,31,30,31,30,31};
	
	static boolean validdate(char[] s,int index){
		int d=getnumber(index,index+2,s);
		int m=getnumber(index+3,index+5,s);
		int y=getnumber(index+6, index+10,s);
		if (!(y>=2013 && y<=2015))
			return false;
		if (!(m>=1 && m<=12))
			return false;
		int diasmes=meses[m-1];
		if (!(d>=1 && d<=diasmes))
			return false;
		return true;
	}
	
	
	public static void main(String args[]) throws NumberFormatException, IOException{
		Scanner sc=new Scanner();
		char[] string=sc.next().toCharArray();
		TreeMap<String,Integer> tm=new TreeMap<String,Integer>();
		for(int i=0;i<string.length;i++){
			if (isadate(string,i)==false)
				continue;
			if (validdate(string,i)==false)
				continue;
			StringBuilder sb=new StringBuilder();
			for(int j=0;j<10;j++)
				sb.append(string[i+j]+"");
			String tmp=sb.toString();
			if (tm.containsKey(tmp))
				tm.put(tmp, tm.get(tmp)+1);
			else
				tm.put(tmp, 1);
		}
		String ans="";
		int MAX=0;
		Set<String> t=tm.keySet();
		for(String actual: t){
			int val=tm.get(actual);
			if (val>MAX){
				MAX=val;
				ans=actual;
			}
		}
		System.out.println(ans);
	}

}
