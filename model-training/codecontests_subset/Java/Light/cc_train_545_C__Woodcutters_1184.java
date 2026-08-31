import java.util.*;

public class SolutionB {
	public static void main(String args[]){
		Scanner s1=new Scanner(System.in);
		int n=s1.nextInt();
		int trees[][]=new int[n][2];
		for(int i=0;i<n;i++){
			trees[i][0]=s1.nextInt();
			trees[i][1]=s1.nextInt();
		}
		int count=2;
		if(n>2){
		for(int i=1;i<n-1;i++){
			if(trees[i][0]-trees[i-1][0]>trees[i][1]){
				count++;
			}
			else if(trees[i+1][0]-trees[i][0]>trees[i][1]){
				count++;
				trees[i][0]=trees[i][1]+trees[i][0];
			}
		}
		
		}
		if(n<=2)
			System.out.println(n);
		else
			System.out.println(count);
	}
}
