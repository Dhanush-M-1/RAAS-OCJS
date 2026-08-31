import java.awt.geom.Point2D;
import java.util.*;


public class Main {
	Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		new Main();
	}
	public Main() {
		new AOJ0110();
	}


	class AOJ0110{
		int cnt;
		int[] list;
		int n;
		public AOJ0110() {
			while(true){
				n = in.nextInt();
				cnt=0;
				if(n==0)break;
				list = new int[n];
				for(int i=0;i<n;i++)list[i] = in.nextInt();
				bubble();
				System.out.println(cnt);
			}
		}
		void bubble(){
			for(int s=0;s<n;s++){
				for(int i=0;i<n-1;i++)if(list[i]>list[i+1])change(i,i+1);
			}
		}
		
		void change(int index1,int index2){
			int a = list[index1];
			list[index1] = list[index2];
			list[index2] = a;
			cnt++;
			return;
		}
	}
	
}