import java.util.Scanner;

public class Main {
	public static int selectionSort(int[] ary,int num){
		int min,tmp,cnt=0;
		for(int i=0;i<num;i++){
			min=i;
			for(int j=i+1;j<num;j++){
				if(ary[j]<ary[min]){
					min=j;
				}
			}
				if(i!=min){
					cnt++;
					tmp=ary[i];
					ary[i]=ary[min];
					ary[min]=tmp;
			}
		}
		return cnt;
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int[] a;
		a = new int[n];
		for(int i=0;i<n;i++){
			a[i]=sc.nextInt();
		}
		int cnt = selectionSort(a,n);
		for(int i=0;i<n-1;i++){
			System.out.printf("%d ",a[i]);
		}
		System.out.printf("%d",a[n-1]);
		System.out.printf("\n");
		System.out.println(cnt);
		sc.close();
	}
}
