import java.util.Arrays;
import java.util.Scanner;
public class Main{
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String line=in.nextLine().replaceAll("\\+","");
		int large=line.length();
		int [] arr=new int [large];
		for(int i=0;i<large;i++){
			arr[i]=line.charAt(i)-'0';
		}
		Arrays.sort(arr);
		String ans="";
		for(int j=0;j<large;j++){
			
			if(j==large-1){
				ans+=arr[j];
			}else{
				
				ans+=arr[j]+"+";
			}
		}
		System.out.println(ans);
}
}
