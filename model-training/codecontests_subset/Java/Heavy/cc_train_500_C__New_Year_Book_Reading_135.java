import java.io.*;
import java.util.*;

public class GB2014C {

	public static HashSet<Integer>used=new HashSet<Integer>();
	
	public static void main (String[]args)throws IOException{
		BufferedReader x = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(x.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int[]w=new int[n];
		st=new StringTokenizer(x.readLine());
		for (int i=0; i<n; i++){
			w[i]=Integer.parseInt(st.nextToken());
		}
		int []order=new int[m];
		st=new StringTokenizer(x.readLine());
		ArrayList<Integer>books=new ArrayList<Integer>();
		for (int i=0; i<m; i++){
			order[i]=Integer.parseInt(st.nextToken())-1;
			if (!used.contains(order[i])){
				books.add(order[i]);
				used.add(order[i]);
			}
		}
		int weight=0;
		for (int i=0; i<m; i++){
			for (int j=0; j<n; j++){
				if (books.get(j)==order[i]){
					int cur=books.get(j);
					for (int k=0; k<j; k++){
						weight+=w[books.get(k)];
					}
					books.remove(j);
					books.add(0,cur);
					break;
				}
			}
		}
		System.out.println(weight);
	}
}