import java.util.Scanner;

class Main{
	public static void main(String[] args) 	{
		Scanner sc = new Scanner(System.in);
		int youso = sc.nextInt();
		int hairetsu[] = new int[youso];
		for(int i = 0;i < youso;i++) {
			hairetsu[i] = sc.nextInt();
		}
		int count = 0;
		int k,j;
		for(k = 0;k< youso - 1;k++) {
			int min = k + 1;
			for(j = k + 1;j <= youso - 1;j++) {
				if(hairetsu[j] < hairetsu[min]) min = j;
			}
			if(hairetsu[k] > hairetsu[min]) {
					int swap = hairetsu[k];
					hairetsu[k] = hairetsu[min];
					hairetsu[min] = swap;
					count++;
			}
		}
		for(int i = 0;i < youso;i++) {
			System.out.printf("%d",hairetsu[i]);
			if(i != youso - 1) System.out.printf(" ");
		}
		System.out.printf("\n%d\n",count);
		sc.close();
	}	
}
