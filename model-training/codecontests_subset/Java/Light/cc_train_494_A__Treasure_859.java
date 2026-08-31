import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Trial{
	
	
	static public void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String in = br.readLine();
		int curr =0,hashes=0,lasthash=-1;
		int[] hashs = new int[in.length()];
		
		for(int i=0;i<in.length();i++){
			if(in.charAt(i)=='#'){
				hashs[hashes++]=1;
				lasthash=i;
			}
		}
		for(int i=0;i<in.length();i++){
			if(i==lasthash)
				continue;
			
			if(in.charAt(i)=='(')
				curr++;
			else 
				curr--;
			
		}
		if(curr<=0)
			curr=1;
		
		hashs[hashes-1]=curr;
		
		int open=0,closed=0,index=0;
		boolean flag=true;
		for(int i=0;i<in.length();i++){
			if(closed>open){
				flag=false;
				break;
			}
			if(in.charAt(i)=='(')
				open++;
			else if(in.charAt(i)==')')
				closed++;
			else{
				closed+=hashs[index++];
			}
		}
		if(closed!=open)
			flag=false;
		
		if(!flag)
			System.out.println("-1");
		else{
			for(int i=0;i<hashes;i++)
				System.out.println(hashs[i]);
		}
		
		
	}
}