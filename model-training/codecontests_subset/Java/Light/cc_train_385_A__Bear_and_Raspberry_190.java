import java.util.*;
public class bear {
public static void main(String args[]){
	Scanner scan = new Scanner(System.in);
	//find largest diff where nums[i]>nums[i+1]
	int size = scan.nextInt(); int c = scan.nextInt();
	int[] nums = new int[size];
	for(int i = 0;i<size;i++){
		nums[i]=scan.nextInt();
	}
	int max = 0;
	int x = 0;
	for(int i  =0;i<size-1;i++){
		if(nums[i]>nums[i+1]&&nums[i]-nums[i+1]>max){
			max=nums[i]-nums[i+1];
			x++;
		}
	}
	if(x>0&&max-c>=0){
	System.out.println(max-c);
	}
	else{
		System.out.println(0);
	}
}
}
