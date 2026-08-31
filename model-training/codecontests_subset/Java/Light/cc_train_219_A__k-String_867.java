import java.util.Arrays;
import java.util.Scanner;


public class k_string {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Scanner in=new Scanner(System.in);
		  int k=in.nextInt();
		  String str=in.next();
		  int arr[]=new int[28];
		  char[] chars = str.toCharArray();
	      Arrays.sort(chars);
	      String str1 = new String(chars);
	       // System.out.println(str1);
		for(int i=0;i<str.length();i++)
			arr[str.charAt(i)-'a']++;
		for(int i=0;i<28;i++){
			if(arr[i]%k!=0){
			System.out.println("-1");
			return;
		}
		}
		for(int i=0;i<k;i++){
		 for(int j=0;j<str.length();j+=k){
		System.out.print(str1.charAt(j));	 
}
}
}
}