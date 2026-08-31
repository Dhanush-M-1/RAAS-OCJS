import java.util.Scanner;

public class Main {
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		TaskC a= new TaskC();
		a.solve(sc);
	}
}




class TaskC{
	
	//int [] dp = new int[10000];
	//int [] tree = new int[100005];
	
	public int solve(Scanner sc){
		int n=sc.nextInt();
		int left_index=0;
		int max_result=0;
		int x,h;
		x=sc.nextInt();
		h=sc.nextInt();
		
		left_index=x;
		//first tree always left.
		max_result++;
		if (n==1){
			System.out.println(1);
			return 0;
		}
		int i=2;
		
		int needRead=1;
		while (i<=n  || needRead == 0){
			if(needRead==1){
				x=sc.nextInt();
				h=sc.nextInt();
				i++;
			}
			//try left first;
			if (x - left_index > h){
				max_result++;
				left_index=x;
				needRead=1;
				continue;//next
			}else {
				//try right
				if( i== n+1){
					max_result++;
					i++;
					break;
				}else{
					int next_x=sc.nextInt();
					int next_h=sc.nextInt();
					i++;
					if( x+ h < next_x){
						//okay.
						left_index=x+h;
						max_result++;
					}else{
						left_index=x;
					}
					x=next_x;
					h=next_h;
					needRead=0;
				}
				
			}
		}
		
		
		System.out.println(max_result);
		return 1;


			

		
	}

}