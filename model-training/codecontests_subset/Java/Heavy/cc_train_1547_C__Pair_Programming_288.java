import java.util.*;
import java.io.*;
public class ProbC {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int cases = Integer.parseInt(bf.readLine());
		
		for(int caseNum=0; caseNum<cases; caseNum++) {
			
			bf.readLine();
			
			st = new StringTokenizer(bf.readLine());
			
			int k = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int[] mono = new int[n];
			int[] poly = new int[m];
			
			st = new StringTokenizer(bf.readLine());
			for(int i=0; i<n; i++)
				mono[i] = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(bf.readLine());
			for(int i=0; i<m; i++)
				poly[i] = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[n+m];
			
			int one = 0;
			int two = 0;
			int ind = 0;
			
			boolean flag = false;
			
			while(one < n || two < m) {
				if(one < n && mono[one] == 0) {
					arr[ind] = mono[one];
					one++;
					ind++;
					k++;
				} else if(two < m && poly[two] == 0) {
					arr[ind] = poly[two];
					two++;
					ind++;
					k++;
				} else if(one < n && k >= mono[one]){
					arr[ind] = mono[one];
					one++;
					ind++;
				} else if(two < m && k >= poly[two]) {
					arr[ind] = poly[two];
					two++;
					ind++;
				} else {
					flag = true;
					break;
				}
				//System.out.println(Arrays.toString(arr));
			}
			
			if(flag)
				System.out.println(-1);
			else {
				for(int i=0; i<n+m-1; i++)
					System.out.print(arr[i]+" ");
				System.out.println(arr[n+m-1]);
			}
		}
		
		bf.close();

	}

}
