import java.io.*;
import java.util.*;
public class RunForYourPrize {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		br.readLine();
		String [] ar = br.readLine().split(" ");
		int [] prizes = new int [ar.length];
		for(int i = 0; i < ar.length;i++){
			prizes[i]= Integer.parseInt(ar[i]);
		}
		Arrays.sort(prizes);
		int ind1 = 1;
		int ind2 = 1000000;
		int mid = ind2/2;
		int res = 0 ;
		int st = 0;
		int end = prizes.length-1;
		while(st<=end){
			int f = prizes[st];
			int l = prizes[end];
			if(f-ind1<=ind2-l){
				res+=(f-ind1);
				ind2-=(f-ind1);
				if(prizes[end]==ind2){
					end--;
				}
				ind1 =f;
				st++;
				
			}else{
				res+=(ind2-l);
				ind1 +=(ind2-l);
				if(prizes[st]==ind1){
					st++;
				}
				ind2 = l;
				end--;
				
			}
		}
		
		System.out.println(res);

	}

}
