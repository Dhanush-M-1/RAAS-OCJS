import java.util.*;
public class prob1{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String[] s1 = sc.nextLine().split("\\s");
		int requirement = Integer.parseInt(s1[1]);
		int buckets = Integer.parseInt(s1[0]);
		//Integer[] volume = new Integer[buckets];
		String[] split = sc.nextLine().split("\\s"); 
		int ans = requirement;
		for(int i=1;i<=buckets;i++){
			int x = Integer.parseInt(split[i-1]);
			if(requirement%x==0 && requirement/x<ans){
				ans = requirement/x;
			}
		}
		System.out.println(ans);

	}

}