import java.util.Scanner;

public class Main{


	public static void SelectionSort(int[] array){
		int len=array.length;
		int cnt=0;
		int min;
		int swap;
		for(int i=0;i<len-1;i++){
			min=i;
			for(int j=i+1;j<len;j++){
			if(array[min]>array[j])min=j;
			}
			if(min!=i){
				cnt++;
				swap=array[i];array[i]=array[min];array[min]=swap;

		}

		}

		//??\????????????
		for(int i=0;i<len;i++){
		System.out.print(array[i]);
		if(i!=len-1)System.out.print(" ");}

		System.out.println();
		System.out.println(cnt);
	}

	public static void main(String[] args){

		int n;

		Scanner scan=new Scanner(System.in);
		n=scan.nextInt();
		int[] box=new int[n];

		for(int i=0;i<n;i++){
		box[i]=scan.nextInt();
		}

		SelectionSort(box);

		scan.close();

	}

}