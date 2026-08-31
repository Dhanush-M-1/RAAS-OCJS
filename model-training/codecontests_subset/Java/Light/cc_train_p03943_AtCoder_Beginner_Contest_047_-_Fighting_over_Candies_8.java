import java.util.Scanner;
import java.util.Arrays;

public class Main{
    public static void main(String[] args){
	Scanner scan = new Scanner(System.in);

	int[] a = new int[3];
	for(int i = 0; i < 3; i++){
	    a[i] = scan.nextInt();
	}

	Arrays.sort(a);
	if(a[2] == a[1]+a[0]){
	    System.out.println("Yes");
	}else{
	    System.out.println("No");
	}
    }
}
