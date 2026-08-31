import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class tree {
	public static void main (String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] input;
		long[] tree = new long[n];
		long[] h = new long[n];
		for (int i=0;i<n;i++){
			input = br.readLine().split(" ");
			tree[i] = Long.parseLong(input[0]);
			h[i] = Long.parseLong(input[1]);
		}
		int contador = n>1?2:1;
		for (int i = 1; i<n-1;i++){
			if (tree[i]-h[i]>tree[i-1]){
				contador++;
			}
			else if (tree[i]+h[i]<tree[i+1]){
				contador++;
				tree[i] = tree[i]+h[i];
			}
		}
		System.out.println(contador);
	}
		
}
