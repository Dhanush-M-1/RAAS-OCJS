import java.util.*;

public class B {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		String arr[] = new String[2];
		
		arr[0] = sc.next();
		arr[1] = sc.next();
		
		System.out.println(arr[0] + " " + arr[1]);
		
		int n = sc.nextInt();
		
		for(int i=0 ;i<n ;i++){
			String kill = sc.next();
			
			if(arr[0].equals(kill))
				arr[0] = sc.next();
			else
				arr[1] = sc.next();
			
			System.out.println(arr[0] + " " + arr[1]);
		}
	}
}