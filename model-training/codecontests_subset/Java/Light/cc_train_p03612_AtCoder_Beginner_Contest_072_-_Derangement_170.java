import java.util.Scanner;

public class Main {
	static int[] p;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		p=new int[N];
		int counter=0;
		for(int i=0; i<N; i++) {
			p[i]=sc.nextInt();
		}
		int check=0;
		while(check<N) {
			if(check+2<N) {	//更に奥の列を見れる時
				if(p[check]!=check+1 && p[check+1]==check+2 && p[check+2]==check+3) {
					//1つ先の2つくみを見る前に自分を木にする
					//1こ先のやつがどっちもスワップしたほうがいい時
					counter++;
					swap(check+1,check+2);
					check++;
				}
				else {
					//1個先の2つ組がどちらかがp_i != i　ならわざわざ先でやる必要はない
					if(p[check]==check+1 || p[check+1]==check+2) {
						counter++;
						swap(check,check+1);
						check++;
					}
					else {
						check++;
						//特に無いなら次を見る
					}
				}
			}
			else if(check+1<N){
				//1個先の2つ組がどちらかがp_i != i　ならわざわざ先でやる必要はない
				if(p[check]==check+1 || p[check+1]==check+2) {
					counter++;
					swap(check,check+1);
					check++;
				}
				else {
					check++;
					//特に無いなら次を見る
				}
			}
			else {
				check++;
			}
		}
		System.out.println(counter);
	}
	static void swap(int i,int j) {
		int tmp1=p[i];
		int tmp2=p[j];
		p[i]=tmp2;
		p[j]=tmp1;
	}
}