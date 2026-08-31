import java.util.Scanner;
class Main {
    public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		int[] num = new int[input];
		int count;
		
		for(int c = 0; c < input; c++){
			num[c] = scan.nextInt();
		}
		
		count = SelectionSort(num, input);
		
		for(int i = 0; i < input; i++){
			if(i != input - 1){
				System.out.print(num[i] + " ");
			}else{
				System.out.println(num[i]);
			}
		}
		System.out.println(count);
	}
	
	static int SelectionSort(int data[], int n){
		int temp;
		int c = 0;
		int min;
		boolean b;
		
		for(int i = 0; i < n - 1; i++){
			min = i;
			b = false;
			
			for(int j = i + 1; j < n; j++){
				if(data[j] < data[min]){
					min = j;
					b = true;
				}
			}
			if(b){
				temp = data[i];
				data[i] = data[min];
				data[min] = temp;
				c++;
			}
		}
		
		return c;
	}
}