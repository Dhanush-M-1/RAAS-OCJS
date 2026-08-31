
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class C545 {

	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] xcoord = new int[n];
		int[] heights = new int[n];
		for(int i=0;i<n;i++){
			String[] a = br.readLine().split(" ");
			xcoord[i] = Integer.parseInt(a[0]);
			heights[i]=Integer.parseInt(a[1]);
		}
		if(n == 1){
			System.out.println(1);
			return;
		}
		int ct = 2;
		int prev = xcoord[0];
		for(int i=1;i<n-1;i++){
			if(xcoord[i] - prev > heights[i]){
				ct++;
				prev = xcoord[i];
			}
			else if(xcoord[i+1] - xcoord[i] > heights[i]){
				ct++;
				prev = xcoord[i] + heights[i];
			}else prev = xcoord[i];
		}
		System.out.println(ct);
		
	}
}