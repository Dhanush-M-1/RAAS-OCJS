import java.util.*;
public class B {
    //static int num = (int)Math.pow(10,6);
	static Scanner sc = null;
	public static void main(String[] args) {
		//System.out.println("Enter :");
		sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int a1[] = new int[6];
		int a2[] = new int[6];
		ArrayList<Integer> ar = new ArrayList<>();
		ar.add(2);
		ar.add(3);
		ar.add(5);
		for(Integer j : ar){
		    while(a%j==0){
		        a1[j]+=1;
		        a/=j;
		    }
		    while(b%j==0){
		        a2[j]+=1;
		        b/=j;
		    }
		}
		if(a!=b)
		    System.out.println("-1");
		    else{
		        int ans = 0;
		        for(int i=0;i<=5;i++){
		            int dif = a1[i]-a2[i];
		            if(dif<0)
		            dif*=-1;
		            ans+=dif;
		        }
		        System.out.println(ans);
		    }
	}
}

