import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		/* Read in from console */
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(System.out);
		
		int t = Integer.parseInt(reader.readLine());
		int[] x = new int[t];
		int[] h = new int[t];
		
		for(int i=0; i<t; i++){
			String[] data = reader.readLine().split("\\s");
			x[i] = Integer.parseInt(data[0]);
			h[i] = Integer.parseInt(data[1]);
		}
		
		int count = 2;
		for(int i=1; i<t-1; i++){
			if(x[i]-h[i] > x[i-1])
				count++;
			else if(x[i]+h[i]< x[i+1]){
				count++;
				x[i] += h[i];
			}
		}
		
		if(t < 2)
			count = t;
		
		writer.println(count);
		writer.close();
	}
}