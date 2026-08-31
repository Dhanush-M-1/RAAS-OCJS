import java.util.Scanner;

class Main {
  public static void main(String[] args) {
  	Scanner sc = new Scanner(System.in);
  	int n = sc.nextInt();
  	int[] a = new int[n];
  	for(int i = 0; i < n; ++i){
  		a[i] = sc.nextInt();
  	}
  	
  	int num = 0;
  	for(int i = 0; i < n; ++i){
  		int minj = i;
  		for(int j = i; j < n; ++j){
  			if(a[minj] > a[j]){
  				minj = j;
  			}
  		}
		if(minj != i){
	  		int tmp = a[minj];
  			a[minj] = a[i];
  			a[i] = tmp;
  			num = num + 1;
  		}	
  	}
  	for(int i = 0; i < n; ++i){
  		System.out.print(i == 0 ? a[i] : " " + a[i]);
  	}
  	System.out.println();
  	System.out.println(num);
  }
}