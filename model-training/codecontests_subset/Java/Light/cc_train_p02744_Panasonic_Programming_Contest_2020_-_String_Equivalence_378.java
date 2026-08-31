//PanasonicD
import java.io.*;
import java.util.*;
public class Main{
static int t,n;
static int[] arr;
static StringBuilder ans=new StringBuilder();
public static void solve(char[] ch,int i,int c){
	//base case
	if(i==ch.length){
		System.out.println(new String(ch));
		return;
	}
	for(int x=0;x<=c;x++){
		ch[i]=(char)(x+'a');
		//we have placed maximum character
		if(ch[i]==(c+'a')){
			solve(ch,i+1,c+1);
		}
		else{
			solve(ch,i+1,c);
		}
	}
}
public static void main(String[] args) throws IOException{
		// BufferedReader br = new BufferedReader(new
  //      FileReader("sampleinp.txt"));
    	BufferedReader br = new BufferedReader( 
                             new InputStreamReader(System.in)); 
	 	
	 	n=Integer.parseInt(br.readLine());
	 	char[] ch=new char[n];
	 	solve(ch,0,0);
    }
}