import java.util.*;
public class Main {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt(); 
		int[] nums = new int[count];
		for(int i=0;i<count;i++){
			nums[i] = sc.nextInt();
		}
		int swap = selectionSort(nums);
		printArray(nums);
		System.out.println(swap);
		
	}
	public static int  selectionSort(int[] nums){
		int swap = 0;
		for(int i=0;i<nums.length;i++){
			int min = i;
			for(int j=i+1;j<nums.length;j++){
				if(nums[j]<nums[min]) min=j;
			}
			if(min!=i){
				int tmp = nums[i];
				nums[i] = nums[min];
				nums[min] = tmp;
				swap++;
			}
		}		
		return swap; 
		
		
	}
	public static void printArray(int[] nums){
		for(int i=0;i<nums.length;i++){
			if(i!=0)System.out.print(" "+nums[i]);
			else System.out.print(nums[i]);
		}
		System.out.println();
	}

}