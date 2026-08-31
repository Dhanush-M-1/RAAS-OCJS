import java.util.*;
public class simpleDP{
	public static void main(String str[]){
		int t;
		Scanner s= new Scanner(System.in);
		t = s.nextInt();
		for(int i=0;i<t;i++){
			int a = s.nextInt();
			int b = s.nextInt();
			int n = s.nextInt();
			int arr[] =new int[3];
			arr[0] = a;
			arr[1] = b;
			arr[2] = a^b;
			int x = (n+1)%3;
			if(x==0)
				System.out.println(arr[2]);
			else if(x==1)
				System.out.println(arr[0]);
			else
				System.out.println(arr[1]);
		}
	}
}