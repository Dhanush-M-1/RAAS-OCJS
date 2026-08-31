import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main{

	static int N;
	static boolean isGood(char[]c){
		for(int i=0;i<N;i++){
			if(c[i]=='*'){
				for(int d=1;i+4*d<N;d++){
					if(c[i+d]=='*'&&c[i+2*d]=='*'&&c[i+3*d]=='*'&&c[i+4*d]=='*')
						return true;
				}
			}
		}
		return false;
	}
	public static void main(String[] args)throws IOException,NumberFormatException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		char[] c=br.readLine().toCharArray();
		if(isGood(c))
			System.out.println("yes");
		else
			System.out.println("no");
		

	}

}
