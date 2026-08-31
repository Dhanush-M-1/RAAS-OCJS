import java.io.*;
import java.util.*;

public class Main{



	public static void main(String[] args){
		Scan scan = new Scan();
		int n = scan.nextInt();
		int[] stack = new int[n];
		int top = 0;
		long result = 0;

		for(int i=0;i<n;i++){
			int temp = scan.nextInt();
			while(top>1 && stack[top-2] >= stack[top-1] && temp >= stack[top-1]){
				result += Math.min(stack[top-2], temp);
				top--;
			}
			stack[top++] = temp;
		}

		top--;
		for(int i=1;i<top;i++){
			result += Math.min(stack[i-1], stack[i+1]);
		}

		System.out.println(result);

	}

}


class Scan implements Iterator<String>{

	BufferedReader buffer;
	StringTokenizer tok;

	Scan(){
		buffer = new BufferedReader(new InputStreamReader(System.in));
	}


	@Override
	public boolean hasNext(){
		while(tok==null || !tok.hasMoreElements()){
			try{
				tok = new StringTokenizer(buffer.readLine());
			}catch(Exception e){
				return false;
			}
		}
		return true;
	}

	@Override
	public String next(){
		if(hasNext()) return tok.nextToken();
		return null;
	}

	@Override
	public void remove(){
		throw new UnsupportedOperationException();
	}

	int nextInt(){
		return Integer.parseInt(next());
	}
}