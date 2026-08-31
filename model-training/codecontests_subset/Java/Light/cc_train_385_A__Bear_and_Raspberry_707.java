
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
public class Main{
	public static void main(String[]args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String s=bf.readLine();
		String[]sa=s.split(" ");
		int n=Integer.parseInt(sa[0]);
		int c=Integer.parseInt(sa[1]);
		s=bf.readLine();
		sa=s.split(" ");
		int[]a=new int[n];
		for(int i=0;i<n;i++){
			a[i]=Integer.parseInt(sa[i]);
		}
		int max=0;
		for(int i=1;i<n;i++){
			if(a[i-1]-a[i]-c>max)
				max=a[i-1]-a[i]-c;
		}
		System.out.println(max);
	
	}
}
