import java.util.*;
import java.io.*;
import java.lang.*;

/*
2
3
0 1 1
1 1 0
3
0 1 5
5 1 0
*/
public class Main{
	

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw=new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

		StringTokenizer st=new StringTokenizer(br.readLine());

		int n=Integer.parseInt(st.nextToken());
		
		st=new StringTokenizer(br.readLine());
		int even=0,odd=0; 
		ArrayList<Integer> o=new ArrayList<>();
		ArrayList<Integer> e=new ArrayList<>();
		for(int i=0;i<n;i++){
			int a=Integer.parseInt(st.nextToken());
			if(a%2==0){
				even++;
				e.add(a);
			}else{
				odd++;
				o.add(a);
			}
		}
		Collections.sort(o);
		Collections.sort(e);
		if(even>odd){
			long ans=0;
			for(int i=0;i<even-odd-1;i++){
					ans+=e.get(i);
			}
			pw.println(ans);
		}else{
			long ans=0;
			for(int i=0;i<odd-even-1;i++){
					ans+=o.get(i);
			}
			pw.println(ans);
		}



		
		pw.close();

	}


}