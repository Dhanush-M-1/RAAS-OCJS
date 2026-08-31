import java.io.*;
//import java.util.StringTokenizer;

import java.util.*;
public class test1 {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int q = Integer.parseInt(br.readLine());
		for(int i = 0;i<q;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			if((double)(l)/d <= 1){
				double i1 = (double)r/(double)d;
				int i2 = (int)Math.ceil(i1);
				if(i1 == i2){
					i2++;
				}
				System.out.println(d*i2);
			}
			else{
				System.out.println(d);
			}
				
		}
         
        
	}

}
