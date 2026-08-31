import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	String[] data = in.readLine().split(" ");
	int n = Integer.parseInt(data[0]);
	int k = Integer.parseInt(data[1]);
	List<Integer> petri = new ArrayList<>(n);
	{
	    StringTokenizer st = new StringTokenizer(in.readLine());
	    while (st.hasMoreTokens()) {
		petri.add(Integer.parseInt(st.nextToken()));
	    }
	}
	Collections.sort(petri);
	int numEaten = 0;
	for (int p : petri) {
	    int e = Collections.binarySearch(petri, p + k);
	    if (e >= 0) {
		numEaten++;
	    } else {
		int i = -e - 2;
		if (0 <= i && i < n) {
		    int a = petri.get(i);
		    if (p < a && a <= p + k) {
			numEaten++;
		    }
		}
	    }
	}
	System.out.println(n - numEaten);
    }
}
