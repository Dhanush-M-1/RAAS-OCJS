import java.util.*;

public class PhoneNumbers{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String st = sc.next();
		if(n < 11){
			System.out.println("0");
		}
		else{
			int count = 0;
			for(int i = 0;i<n;i++){
				if(st.charAt(i) == '8'){
					count++;
				}
			}
			int i = n/11;
			if(count >= i)
				System.out.println(i);
			else if(count < i)
				System.out.println(count);
		}
	}
}