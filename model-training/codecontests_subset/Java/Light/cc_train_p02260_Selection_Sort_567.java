import java.util.Scanner;
public class Main {
	static void swap(int[] data,int x,int y){
		int tmp=data[x];
		data[x]=data[y];
		data[y]=tmp;
	}
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		int[] data=new int[N];
		int count=0,mini;
		for(int i=0;i<N;i++) data[i]=scan.nextInt();
		for(int i=0;i<N;i++){
			mini=i;
			for(int j=i;j<N;j++){
				if(data[j]<data[mini]){
					mini=j;
				}
			}
			if(i!=mini){
				swap(data,i,mini);
				count++;
			}
		}
		for(int i=0;i<N;i++){
			if(i==0) System.out.print(data[i]);
			else System.out.print(" "+data[i]);
		}
		System.out.printf("\n%d\n",count);
		scan.close();
	}
}