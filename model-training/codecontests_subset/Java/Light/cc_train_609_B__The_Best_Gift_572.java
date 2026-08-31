import java.util.*;

import java.io.*;
public class Main {
		public static void main(String[] args) throws NumberFormatException, IOException {
			boolean file = false;
			BufferedReader br =!file?new BufferedReader(new InputStreamReader(System.in)):new BufferedReader(new FileReader("rect.in"));
			PrintWriter out  = new PrintWriter(System.out);
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[] arr = new int[m];
			st = new StringTokenizer(br.readLine());
			
			for(int i=0;i<n;i++)
				{
				int x =Integer.parseInt(st.nextToken()); 
				arr[x-1]++;
				}
			long sum = 0;
			for(int i=0;i<m;i++)
				for(int j=i+1;j<m;j++)
					sum+= arr[i]*arr[j];
			
			out.println(sum);
				
		out.flush();
		out.close();
		}
		

		}