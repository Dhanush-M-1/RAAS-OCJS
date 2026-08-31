import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class acmmm {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a[] = new int [5];
		
		for(int i=0;i<5;i++){
			a[i]= Integer.parseInt(st.nextToken());
			
		}
		
		int sum =0;
		
		for(int i=0;i<5;i++)
			sum+=a[i];
		if(sum==0)
			System.out.println("-1");
		else {if(sum%5==0)
			System.out.println(sum/5);
		else
			System.out.println("-1");
	}}}
		