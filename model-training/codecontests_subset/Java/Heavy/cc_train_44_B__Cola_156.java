import java.io.*;
import java.util.*;
public class Answer44B{
    public static void main(String[] args){
	BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
	new Kai(reader).solve();
    }
}
class Kai{
    BufferedReader reader;
    public Kai(BufferedReader reader){
	this.reader=reader;
    }
    public void solve(){
	//TODO
	String[] tmp=read().split(" ");
	int n=to_i(tmp[0])*2;
	int[] a={to_i(tmp[1]),to_i(tmp[2]),to_i(tmp[3])};
	int[] b={1,2,4};
	int[][] memo=new int[n+1][4];
	memo[0][0]=1;
	for(int j=0;j<3;j++){
	    for(int k=0;k<=a[j];k++){
		for(int i=0;i<=n;i++){
		    if(i+k*b[j]<=n){
			memo[i+k*b[j]][j+1]+=memo[i][j];
		    }
		}
	    }
	}
	pln(memo[n][3]);
    }
    //tools//////////////////////////////////////////////////
    public String read(){
	String s=null;
	try{
	    s=reader.readLine();
	}catch(IOException e){
	    e.printStackTrace();
	}
	return s;
    }
    public int[] to_i(String[] s){
	int[] tmp=new int[s.length];
	for(int i=0;i<s.length;i++){
	    tmp[i]=to_i(s[i]);
	}
	return tmp;
    }
    public long[] to_l(String[] s){
	long[] tmp=new long[s.length];
	for(int i=0;i<s.length;i++){
	    tmp[i]=to_l(s[i]);
	}
	return tmp;
    }
    public int to_i(String s){
	return Integer.parseInt(s);
    }
    public long to_l(String s){
	return Long.parseLong(s);
    }
    public void p(Object s){
	System.out.print(s);
    }
    public void pln(Object s){
	System.out.println(s);
    }
    public void debug(Object s){
	System.err.print(s);
    }
    public void debugln(Object s){
	System.err.println(s);
    }
}