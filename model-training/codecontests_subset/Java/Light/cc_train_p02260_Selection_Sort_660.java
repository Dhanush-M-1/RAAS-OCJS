import java.util.Arrays;
import java.util.Scanner;

class Main{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);

		int N=sc.nextInt();
		int[] origin=new int[N];
		for(int i=0; i<N; i++) {
			origin[i]=sc.nextInt();
		}

		int res=selection_sort(origin,N);
		Arrays.sort(origin);
		String a="";
		for(int i=0; i<N*2-1; i++) {
			if(i%2==0) {
				a=a+origin[i/2];
			}
			else {
				a=a+" ";
			}
		}
		System.out.println(a);
		System.out.println(res);

	}

	public static int selection_sort(int[] array,int N) {
		int vol=array.length;
		int mini=0;
		int tmp1=0; int tmp2=0;
		int counter=0;
		for(int i=0; i<N; i++) {
			mini=i;
			for(int j=i; j<N; j++) {
				if(array[j]<array[mini]) {
					mini=j;
				}
			}
			if(i!=mini) {
				counter++;
				tmp1=array[i];
				tmp2=array[mini];
				array[i]=tmp2;
				array[mini]=tmp1;
			}
		}
		return counter;
	}
}
