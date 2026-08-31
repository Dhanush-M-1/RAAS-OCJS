import java.util.Scanner;


public class AGAMES {

	public static void main(String[] args) {
		Scanner call = new Scanner (System.in);
		int n = call.nextInt();
		int[] host = new int[n];
		int[] guest = new int[n];
		for(int i=0 ;i<n ;i++){
			host[i] = call.nextInt();
			guest[i] = call.nextInt();
		}
		int count=0 ;
		for(int i=0 ;i<n ;i++){
			for(int j=0 ;j<n ;j++){
				if(host[i]==guest[j]){
					count++;
				}
			}
		}
		System.out.println(count);
	}

}
