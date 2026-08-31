import java.util.*;
 
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
		ArrayList<Integer> al = new ArrayList<>();
		int a = sc.nextInt();
		for (int i=0;i<N-1;i++){
			int b = sc.nextInt();
			if(b == a+1){al.add(a-1);}
			a = b;
		}
		int Ans = 0;
		for (int i=0;i<N;i++){Ans += sc.nextInt();}
		for (int i=0;i<N-1;i++){Ans += sc.nextInt()*((al.contains(i))?1:0);}
		System.out.println(Ans);
		sc.close();
	}
}
