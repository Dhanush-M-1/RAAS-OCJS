
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int array[] = new int[Integer.parseInt(br.readLine())];
		for(int i=0; i<array.length; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}

		int prime = 0;
		boolean p;
		for(int n : array) {
			p = true;
			for(int i=2; i<=Math.sqrt(n); i++) {
				if(n%i==0) {
					p = false;
					break;
				}
			}
			if(p) prime++;
		}
		System.out.println(prime);
	}

}

