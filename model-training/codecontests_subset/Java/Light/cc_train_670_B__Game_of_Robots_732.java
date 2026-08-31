import java.util.Scanner;

public class GameOfRobots {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int k=s.nextInt();
		int input[]=new int[n];
		int i;
		for(i=0;i<n;i++)
		{
			input[i]=s.nextInt();
		}
		boolean flag=false;
		for(i=0;i<input.length;i++)
		{
			if((k-i)>0){
				k-=i;
			}
			else{
				System.out.println(input[k-1]);
				flag=true;
				break;
			}
		}
		if(flag==false){
			System.out.println(input[k-1]);
		}
	}
}