import java.util.*;
import java.io.*;


public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{	
		StreamTokenizer in  = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
	
		in.nextToken();
		int k = (int)in.nval;		
	
		int[][] table = new int[k][k];
		
		for(int i =0; i<k; i++){
			for(int j=0; j<k; j++){
				table[i][j]= (i+1)*(j+1);
			}
		}
		
		if(k<10){
			for(int i =0; i<k; i++){
				for(int j=0; j<k; j++){
					table[i][j]= 10*(table[i][j]/k)+(table[i][j]%k);
				}
			}
		}
		
		for(int i =0; i<k-1; i++){
			for(int j=0; j<k-1; j++){
				if(j == 0){
					System.out.print(table[i][j]);
				}else{
					System.out.printf("%3d", table[i][j]);
				}
			}
			System.out.println();
		}
		
	}

}
