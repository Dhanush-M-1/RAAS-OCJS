import java.util.ArrayList;
import java.util.Scanner;


public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n,error,count=0;
		ArrayList<Integer>errors = new ArrayList<Integer>();
		n = input.nextInt();
		
		for(int i=0 ; i<3 ; i++){
			int sum =0;
			for(int j=count ; j<n ; j++){
				error = input.nextInt();
				sum += error;
			}
			errors.add(sum);
			count++;
		}
		
		for(int i=0 ; i<errors.size()-1 ; i++){
			int result = errors.get(i)-errors.get(i+1);
			System.out.println(result);
		}
	}

}
