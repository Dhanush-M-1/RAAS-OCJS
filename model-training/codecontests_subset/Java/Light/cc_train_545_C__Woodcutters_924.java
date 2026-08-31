import java.util.Scanner;

public class _545c {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int[][]tree = new int[num][2];
		int left=0;
		int count=0;
		if(num==1)count=1;
		else if(num>1)count=2;
		for(int i=0; i<num; i++){
			for(int j=0;j<2;j++){
				tree[i][j]=scan.nextInt();
				}
		}
		for(int i=1;i<num-1;i++){
			left=0;
			if(tree[i][0]-tree[i][1] > tree[i-1][0]){
				count++;
				left=1;
			}else if(tree[i][0]+tree[i][1] < tree[i+1][0] && left==0){
				count++;
				tree[i][0]+=tree[i][1];
			}
		}
		System.out.println(count);
	}
}
