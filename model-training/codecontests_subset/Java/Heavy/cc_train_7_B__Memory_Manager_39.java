import java.io.*;
import java.util.*;
public class Answer7B{
    public static void main(String[] args){
	BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
	new Kai(reader).solve();
    }
}
class Kai{
    BufferedReader reader;
    int[] memory;
    int number=0;
    public Kai(BufferedReader reader){
	this.reader=reader;
    }
    public void solve(){
	//TODO
	String[] tmp=read().split(" ");
	memory=new int[to_i(tmp[1])];
	int m=to_i(tmp[0]);
	for(int i=0;i<m;i++){
	    tmp=read().split(" ");
	    if(tmp.length==1){
		defrag();
	    }else if(tmp[0].equals("alloc")){
		int n=alloc(to_i(tmp[1]));
		if(n!=-1){
		    println(n);
		}else{
		    println("NULL");
		}
	    }else{
		String s=erase(to_i(tmp[1]));
		if(s!=null){
		    println(s);
		}
	    }
	}   
    }
    public String read(){
	String s=null;
	try{
	    s=reader.readLine();
	}catch(IOException e){
	    e.printStackTrace();
	}
	return s;
    }
    public int alloc(int n){
	int[] num=getFree(n);
	if(num==null)return -1;
	number++;
	for(int i=num[0];i<=num[1];i++){
	    memory[i]=number;
	}
	return number;
    }
    public String erase(int n){
	if(n==0)return "ILLEGAL_ERASE_ARGUMENT";
	boolean erase=false;
	for(int i=0;i<memory.length;i++){
	    if(memory[i]==n){
		memory[i]=0;
		erase=true;
	    }
	}
	if(erase)return null;
	else return "ILLEGAL_ERASE_ARGUMENT";
    }
    public void defrag(){
	for(int i=0;i<memory.length;i++){
	    if(memory[i]==0){
		for(int j=i+1;j<memory.length;j++){
		    if(memory[j]!=0){
			memory[i]=memory[j];
			memory[j]=0;
			break;
		    }
		}
	    }
	}
    }
    public int[] getFree(int n){
	int free=0;
	for(int i=0;i<memory.length;i++){
	    if(memory[i]==0)free++;
	    else free=0;
	    if(free==n){
		return new int[]{i-free+1,i};
	    }
	}
	return null;
    }
    public int to_i(String s){
	return Integer.parseInt(s);
    }
    public long to_l(String s){
	return Long.parseLong(s);
    }
    public void print(Object s){
	System.out.print(s);
    }
    public void println(Object s){
	System.out.println(s);
    }
    public void debug(Object s){
	System.err.print(s);
    }
    public void debugln(Object s){
	System.err.println(s);
    }
    public void debug(Object[] s){
	System.err.print(Arrays.deepToString(s));
    }
    public void debugln(Object[] s){
	System.err.print(Arrays.deepToString(s));
    }
}