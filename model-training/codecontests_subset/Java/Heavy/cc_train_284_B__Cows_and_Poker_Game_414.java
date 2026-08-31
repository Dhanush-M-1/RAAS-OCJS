import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class b{
    public static void main(String args[]) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		String s=st.nextToken();
		int As=0;
		int Fs=0;
		int Is=0;
		for(int i=0;i<n;i++){
			if(s.charAt(i)=='A') As++;
			if(s.charAt(i)=='F') Fs++;
			if(s.charAt(i)=='I') Is++;
		}
		if(Is==0) System.out.println(As);
		else if(Is==1) System.out.println("1");
		else System.out.println("0");
    }
}