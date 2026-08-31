import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int change =0;
		int num[] = new int[count];
		for(int i=0; i<count; i++) {
			num[i]=sc.nextInt();
		}

		for(int i=0; i<num.length-1; i++) {
			int min=i;
			for(int j=i+1; j<num.length; j++) {
				if(num[min]>num[j]) {
	  				min=j;
				}
			}
			 if (i == min) {
	                continue;
	            }

			int tmp =num[i];
					num[i]=num[min];
					num[min]=tmp;
	  				change ++;
		}
		  System.out.println(Arrays.toString(num)
	                .replaceAll("[\\[\\],]", ""));
		  System.out.println(change);
	}

}
