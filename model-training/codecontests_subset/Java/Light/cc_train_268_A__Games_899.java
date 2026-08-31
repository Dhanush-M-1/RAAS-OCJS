import java.util.*;
public class Main {
    public static void main(String []args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] x = new int[n];
		int [] y = new int[n];
		for(int i=0;i<n;i++){
			x[i]=sc.nextInt();
			y[i]=sc.nextInt();
		}
		int count = 0;
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(y[j]==x[i])
					count++;
			}
		}
		System.out.print(count);
	}
}