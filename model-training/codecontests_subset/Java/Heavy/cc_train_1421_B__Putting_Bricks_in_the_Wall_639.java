import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _0905PuttingBricksintheWall {
	public int x;
	public int y;

	public _0905PuttingBricksintheWall(int x,int y) {
	this.x=x;
	this.y=y;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		while(t>0) {
			int n=sc.nextInt();
			char[][] arr = new char[n][n];
			sc.nextLine();
			for(int i=0;i<n;i++) {
				String temp=sc.nextLine();
				for(int j=0;j<n;j++) {
					arr[i][j]=temp.charAt(j);
				}
			}
			List<_0905PuttingBricksintheWall> store = new ArrayList<_0905PuttingBricksintheWall>();
			int startVal1=Integer.valueOf(arr[0][1]+"");
			int startVal2=Integer.valueOf(arr[1][0]+"");
			int endVal1=Integer.valueOf(arr[n-2][n-1]+"");
			int endVal2=Integer.valueOf(arr[n-1][n-2]+"");
			if(startVal1==startVal2) {
				int start=startVal1;
				if(endVal1==start) {
					store.add(new _0905PuttingBricksintheWall(n-1, n));
				}
				if(endVal2==start) {
					store.add(new _0905PuttingBricksintheWall(n, n-1));

				}
				
			}
			else if(endVal1==endVal2) {
				int end=endVal1;
				if(startVal1==end) {
					store.add(new _0905PuttingBricksintheWall(1, 2));
				}
				if(startVal2==end) {
					store.add(new _0905PuttingBricksintheWall(2, 1));

				}	
				
			}
			else {
				if(startVal1!=1) {
					store.add(new _0905PuttingBricksintheWall(1, 2));
				}
				if(startVal2!=1) {
					store.add(new _0905PuttingBricksintheWall(2, 1));
				}
				if(endVal1!=0) {
					store.add(new _0905PuttingBricksintheWall(n-1, n));
				}
				if(endVal2!=0) {
					store.add(new _0905PuttingBricksintheWall(n, n-1));
				}
	
			}
			System.out.println(store.size());
			for(int i=0;i<store.size();i++) {
				System.out.println(store.get(i).x+" "+store.get(i).y);
			}
			
			t--;
		}
	}

}
