import java.util.*;
public class contest5{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		String s = sc.next();
		
		int count = 0;
		
		for(int i=0;i<n;i++){
			if(s.charAt(i) == '8'){
				if(count > (n/11)){
					break;
				}else{
					count++;
				}
			}
		}
		if(count >= (n/11)){
			System.out.println((n/11));
		}else{
			System.out.println(count);
		}
		
	}
}