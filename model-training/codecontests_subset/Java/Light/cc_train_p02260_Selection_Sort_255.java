import java.util.*;

class Main {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		int[] ary = new int[n];

		for (int i=0; i<n; i++) {
			ary[i] = stdIn.nextInt();
		}

		int count = 0;
		for (int i=0; i<ary.length; i++) {
			int mini = i;
			for (int j=i; j<ary.length; j++) {
				if (ary[j] < ary[mini]) {
					mini = j;
				}
			}
			swap(ary,i,mini);
			if(i != mini)
				count++;
		}

		for (int i=0; i<n-1; i++) {
			System.out.print(ary[i]+" ");
		}
		System.out.println(ary[n-1]);
		System.out.println(count);
	}

	static void swap(int[] ary,int x,int y){
		int temp = ary[x];
		ary[x] = ary[y];
		ary[y] = temp;
	}
}