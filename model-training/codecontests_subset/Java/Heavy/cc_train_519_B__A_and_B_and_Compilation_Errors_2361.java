import java.io.*;
import java.util.*;

public class problem519B {
	public static void main (String[]args)throws IOException{
		BufferedReader x=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(x.readLine());
		StringTokenizer st=new StringTokenizer(x.readLine());
		int[]first=new int[n];
		for (int i=0; i<n; i++){
			first[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(first);
		int[]second=new int[n-1];
		st=new StringTokenizer(x.readLine());
		for (int i=0; i<n-1; i++){
			second[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(second);
		boolean printed=false;
		for (int i=0; i<n-1; i++){
			if (second[i]!=first[i]){
				System.out.println(first[i]);
				printed=true;
				break;
			}
		}
		if (!printed)System.out.println(first[n-1]);
		int[]third=new int[n-2];
		st=new StringTokenizer(x.readLine());
		printed=false;
		for (int i=0; i<n-2; i++){
			third[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(third);
		for (int i=0; i<n-2; i++){
			if (second[i]!=third[i]){
				System.out.println(second[i]);
				printed=true;
				break;
			}
		}
		if (!printed)System.out.println(second[n-2]);
	}
}