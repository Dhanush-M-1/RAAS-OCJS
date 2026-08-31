import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringJoiner;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine());
		int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		int counter = 0;
		for(int i = 0; i < n; i++){
			int minj = i;
			for(int j = i; j < n; j++){
				if(array[j] < array[minj]){
					minj = j;
				}
			}
			if(minj != i){
				int v = array[i];
				array[i] = array[minj];
				array[minj] = v;
				counter++;
			}
		}
		
		StringJoiner sj = new StringJoiner(" ");
		Arrays.stream(array).forEach(v -> sj.add(String.valueOf(v)));
		System.out.println(sj);
		System.out.println(counter);
	}
}

