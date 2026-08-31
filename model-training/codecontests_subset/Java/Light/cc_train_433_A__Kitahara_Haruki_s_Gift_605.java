import java.util.Scanner;


public class KithariaGift {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] arr = new int[n];
		int counter1=0;
		int counter2=0;
		int total=0;
	   for(int i=0; i<n;i++){			
		   arr[i] = input.nextInt();
		   total+=arr[i];
		   if(arr[i]==100)counter1++;
		   else counter2++;
	   }
	   total = total/2;
	   if(total%100==0){
		   int k = total/100;
		   while(k>counter1 && counter2>0){
			   k = k-2;
			   counter2--;
		   }
		   if(k>=0 && 
				   k<=counter1)System.out.println("YES");
		   else
			   System.out.println("NO");
	   }
	   else
		   System.out.println("NO");
	}

}
