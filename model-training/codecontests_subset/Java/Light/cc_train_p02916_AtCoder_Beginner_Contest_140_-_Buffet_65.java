import java.util.*;

class Main{
	static public void main(String[] args){
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();//料理の種類
		int[] an=new int[n+1];//料理を食べる順番
		int[] bn=new int[n+1];//1-nまでの満足度
		int[] cn=new int[n-1];//満足度
		
		int sum=0;
		for(int i=0;i<n;i++){
			an[i]=sc.nextInt();
		}
		for(int i=0;i<n;i++){
			bn[i]=sc.nextInt();
		}
		for(int i=0;i<n-1;i++){
			cn[i]=sc.nextInt();
		}
		
		for(int i=0;i<n;i++){
			int a=an[i]-1;
			sum+=bn[a];
			if(an[i+1]-an[i]==1){
				int ss=an[i+1]-2;
				sum+=cn[ss];
			}
		}
		
		System.out.println(sum);
		
	}
}