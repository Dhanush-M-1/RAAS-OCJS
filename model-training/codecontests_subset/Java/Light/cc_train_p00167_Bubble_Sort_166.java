import java.io.*;
import java.util.*;

class Main {
	static Scanner sc=new Scanner (System.in);
	static int n;
	static Main app=new Main();
	int array[];
	int temp[];
	static int count;


	void doing(){
		for(int i=1;i<app.array.length;i++){
			//System.err.println(count);
			int temp=0;
			if(app.array[i-1]>app.array[i]){
				temp=app.array[i];
				app.array[i]=app.array[i-1];
				app.array[i-1]=temp;
				count++;
			}
		}
	}

	public static boolean judge(){
		boolean judge=true;
		for(int i=0;i<app.array.length;i++){
			/*System.err.print(judge);
			System.err.print(app.array.length);
			*/
			if(app.array[i]!=app.temp[i]){
				judge=false;
			}
		}
		if(judge){
			return true;
		}
		return false;
	}




	public static void main(String[] args) {
		while(true){
			n=sc.nextInt();
			app.array=new int[n];
			app.temp=new int [n];
			count=0;
			
			if(n==0)break;
			//System.err.println("------");
			for(int i=0;i<n;i++){
				app.array[i]=sc.nextInt();
				app.temp[i]=app.array[i];
				//System.out.print(app.array[i]);
			}
			//System.err.println("------");
			Arrays.sort(app.temp);
			while(!judge()){
				app.doing();
			}
			System.out.println(count);
		}
	}
}