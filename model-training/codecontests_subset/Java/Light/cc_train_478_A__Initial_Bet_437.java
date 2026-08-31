import java.util.*;
public class Main{
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		int[] c = new int[5];
		int sum=0;
		for(int i=0;i<5;i++){
			sum+=scn.nextInt();
		}
		int ret=-1;
		if(0<sum && sum%5==0){
			ret=sum/5;
		}
		System.out.println(ret);
	}
}

