import java.util.*;
public class Main {
	static int count = 0;
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		int[] nums  =new int[n];
		for(int i=0;i<n;i++){
			nums[i] = sc.nextInt();
		}
		selectionSort(nums);
		for(int i=0;i<nums.length;i++){
			if(i>0)System.out.print(" ");
			System.out.print(nums[i]);
		}
		System.out.println();
		System.out.println(count);
	}
	public static void selectionSort(int[] nums){
		for(int i=0;i<nums.length;i++){
			int min = i;
			for(int j=i;j<nums.length;j++){
				if(nums[j]<nums[min]){
					min  = j;
				}
			}
			if(min!=i){
				count++;
				swap(nums,min,i);
			}
		}
	}
	public static void swap(int[] A,int i ,int j){
		int t = A[j];
		A[j] = A[i];
		A[i] = t;
	}
}