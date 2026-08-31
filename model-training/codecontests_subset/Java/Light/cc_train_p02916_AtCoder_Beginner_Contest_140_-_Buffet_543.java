import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] order = new int[n];
		int[] points = new int[n];
		int[] extra = new int[n-1];
		for(int i = 0;i<n;i++) {
			order[i]=sc.nextInt();
		}
		for(int i = 0;i<n;i++) {
			int temp = sc.nextInt();
			points[i] = temp;
		}
		for(int i = 0;i<n-1;i++)extra[i]=sc.nextInt();
		//for(int i = 0;i<n;i++)System.out.print(points[order[i]-1]+" ");
		int output = points[order[0]-1];
		for(int i = 1;i<n;i++) {
			output+= points[order[i]-1];
		}
		for(int i = 1;i<n;i++) {
			if(order[i]-1==order[i-1])output+=extra[order[i-1]-1];
		}
		System.out.println(output);
	}

}
