import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class ParityAlternatedDeletions {			//1144B
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		ArrayList<Integer> ar1 = new ArrayList<>();
		ArrayList<Integer> ar2 = new ArrayList<>();
		int ec = 0, oc = 0, sum = 0;
		for (int i = 0; i < n; i++) {
			int t = Integer.parseInt(st.nextToken());
			if((t & 1) == 1) { ar1.add(t); oc++; }
			else { ar2.add(t); ec++; }
		}
		Collections.sort(ar1);
		Collections.sort(ar2);
		if(ec < oc)
		{
			oc = oc - ec - 1;
			for(int i = 0; i < oc; i++)
				sum += ar1.get(i);
		}
		else if(ec > oc)
		{
			ec = ec - oc - 1;
			for(int i = 0; i < ec; i++)
				sum += ar2.get(i);
		}
		System.out.println(sum);
	}
}