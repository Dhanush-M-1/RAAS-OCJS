import java.util.*; 
public class Main{
	static public void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int[] num={1, 1, 1, 2, 1, 2, 1, 5, 2, 2, 1, 5, 1, 2, 1, 14, 1, 5, 1, 5, 2, 2, 1, 15, 2, 2, 5, 4, 1, 4, 1, 51};
		int k=sc.nextInt()-1;
		System.out.print(num[k]);
		sc.close();
	}
}