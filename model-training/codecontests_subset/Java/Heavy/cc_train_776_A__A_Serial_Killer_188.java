import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class code766A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner get = new Scanner(System.in);
		String[] arr = new String[2];
		String s = get.nextLine();
		arr = s.split(" ");
		int n =get.nextInt();
		get.nextLine();
		//System.out.println(Arrays.toString(arr));
		System.out.println(arr[0]+" "+arr[1]);
		for(int i=0;i<n;i++){
			s = get.nextLine();
			String[] ta = s.split(" ");
			//System.out.println(Arrays.toString(ta));
			if(ta[0].equals(arr[0])){
				arr[0]=ta[1];
			}
			else if(ta[0].equals(arr[1])){
				arr[1]=ta[1];
			}
			//System.out.print("==");
			//System.out.println(Arrays.toString(arr));
			System.out.println(arr[0]+" "+arr[1]);
		}
		
	}

}
