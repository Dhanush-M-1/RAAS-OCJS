import java.util.Scanner;

public class Problem {
	public  int[] insertionSort(int[] array) {
		for(int i = 1; i<array.length; i++) {
			int current = array[i];
			int j = i-1;
			while(j>=0 && current < array[j]) {
				int temp = array[j];
				array[j] = array[j+1];
				array[j+1] = temp;
				j--;
				
			}
		}
		return array;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		int y = s.length();
		String[] list = new String[y/2+1];
		int[] array = new int[y/2+1];
		int count = 0;
		int i = 0;
		int[] c = new int[array.length];
		Problem b = new Problem();
		while (i < (y/2+1)) {
			
			list[i] = s.substring(0+count,1+count);
			array[i] = Integer.parseInt(list[i]);
		
			count+=2;
		i++;	
		}	
		for(int l = 0; l<array.length; l++) {
			if(l+1 !=array.length) {
			System.out.print(b.insertionSort(array)[l] + "+");
			} else {
				System.out.print(b.insertionSort(array)[l]);
			}
		}
		
	
}
}