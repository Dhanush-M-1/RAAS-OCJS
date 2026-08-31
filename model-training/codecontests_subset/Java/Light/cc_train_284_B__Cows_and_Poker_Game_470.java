import java.util.Scanner;

public class B_284_Cows_and_Poker_Game {
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		String s=input.next();
		char[] array=s.toCharArray();
		int n1=0,n2=0;
		for(int i=0;i<n;i++)
			if(array[i]=='A')n1++;
			else if(array[i]=='I')n2++;
		int count;
		if(n2>1)count=0;
		else if(n2==1)count=1;
		else count=n1;
		System.out.println(count);
	}
}
