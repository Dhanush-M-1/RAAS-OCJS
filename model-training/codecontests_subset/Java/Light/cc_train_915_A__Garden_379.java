import java.util.*;
public class practice {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		int min =Integer.MAX_VALUE;
		for(int i=0;i<n;i++){
			int x=sc.nextInt();
			if(k%x==0){
				min=Math.min(min, k/x);
			}
		}
		System.out.println(min);
	}

}
