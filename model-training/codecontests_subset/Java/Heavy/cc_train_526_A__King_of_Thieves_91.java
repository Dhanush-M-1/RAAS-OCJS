import java.util.*;
import java.io.*;

public class Solution{
	
	BufferedReader br;

	public void run() throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		String str = br.readLine().trim();

		char [] arr = str.toCharArray();
		int len = arr.length;
		int count = 0;

		for(int j=1;j<=(len-1)/4;j++){
			for(int i=0;i<len;i++){
				int start = i;

				if(arr[start] == '.')	
					continue;
				
				while(start+j<len){
					if(arr[start+j] == '.')
						break;
					count++;
					start += j;
					if(count >=4)
						break;
				}

				if(count>=4)
					break;
				else
					count = 0;
			}
			if(count>=4)
				break;
			else
				count = 0;
		}

		if(count >=4)
			System.out.println("yes");
		else
			System.out.println("no");
	}

	public static void main(String [] args)throws IOException{
		new Solution().run();
	}
}

