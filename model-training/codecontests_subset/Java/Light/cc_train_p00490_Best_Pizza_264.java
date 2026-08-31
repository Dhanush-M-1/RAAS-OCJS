import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int basePrice=sc.nextInt();
		int topPrice=sc.nextInt();
		int sumCal=sc.nextInt();
		int[] topCal=new int[n];
		int tmp=sumCal/basePrice;
		int next,cnt=0;
		for(int i=0;i<n;i++){
			topCal[i]=sc.nextInt();
		}
		java.util.Arrays.sort(topCal);
		for(int i=n-1;i>=0;i--){
			cnt++;
			sumCal+=topCal[i];
			next=sumCal/(cnt*topPrice+basePrice);
			if(tmp>next){
				break;
			}
			tmp=next;
		}
		System.out.println(tmp);
	}
}