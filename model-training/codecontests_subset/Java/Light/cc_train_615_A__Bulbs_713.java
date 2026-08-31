import java.util.Hashtable;
import java.util.Scanner;

public class A {
	public static void main(String[] argv){
		Scanner sc = new Scanner(System.in);
		int n,m,count=0;
		Hashtable<Integer, Boolean> t1;
		n=sc.nextInt();
		m=sc.nextInt();
		t1 = new Hashtable<Integer, Boolean>(m+1);
		for(int i=0;i<n;i++){
			int num = sc.nextInt();
			for(int j=1;j<=num;j++){
				int key = sc.nextInt();
				boolean tmp=t1.containsKey(key);
				if(!tmp){
					t1.put(key, true);
					count++;
				}
			}
		}
		//System.out.println(count);
		if(count==m)
			System.out.println("YES");
		else
			System.out.println("NO");
		sc.close();
	}
}
