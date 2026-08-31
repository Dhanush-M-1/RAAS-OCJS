import java.util.*;
public class A195 {
	public static void main(String[] args){
		Scanner br = new Scanner(System.in);
		int a = br.nextInt();
		int b = br.nextInt();
		int c = br.nextInt();
		int high = (a*c)/b + 1;
		int low = 0;
		while(high-low > 1){
			int mid = (high+low)/2;
			boolean good = true;
			for(int i = 0;i<=c;i++){
				if((mid+i)*b < i*a){
					good = false;
					break;
				}
			}
			if(good){
				high = mid;
			}
			else{
				low = mid;
			}
		}
		System.out.println(high);
	}
}
