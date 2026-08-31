import java.util.Arrays;
import java.util.Scanner;

public class _9HelpfulMaths {

	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	String sum=	sc.nextLine();
	if(sum.length()==1) {
		System.out.println(sum);
		return;
	}
	int[] numSort = new int[sum.length()/2+1];
	int k=0;int temp=0;
	while(k<sum.length()) {	
		numSort[temp++]=Integer.parseInt(sum.charAt(k)+"");
		k=k+2;
	}
	Arrays.sort(numSort);
	String output = numSort[0]+"";
	k=1;
	do {
		output+="+"+numSort[k++];
	}
	while(k<numSort.length); 
		System.out.print(output);
	}

}
