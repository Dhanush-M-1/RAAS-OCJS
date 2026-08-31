import java.util.*;

public class Main {
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		String a[] = str.split(" ");
		int len = a.length;
		int n = Integer.valueOf(a[len - 1]);
		int cnt1 = 0;
		int cnt2 = 0;
		for(int i = 0 ; i < len ; i ++){
			if(a[i].equals("+")){
				cnt1 ++;
			}
			if(a[i].equals("-")){
				cnt2 ++;
			}
		}
		if(cnt1 == 0){
			if(cnt2 != 0){
				System.out.println("Impossible");
				return;
			}else{
				System.out.println("Possible");
				System.out.println(n +" = "+n);
				return;
			}
		}else{
 // System.out.println(cnt1 +" "+cnt2);
			cnt1 ++;
			if(cnt2 + n > cnt1 * n){
				System.out.println("Impossible");
				return;
			}else if(cnt1 > (cnt2 + 1) * n){
				System.out.println("Impossible");
				return;
			}
			else{
				int cur = (cnt2 + n) / cnt1 ;
				int cur2 = (cnt2 + n) % cnt1 ;
  // System.out.println(cur +" "+cur2);
  				boolean flag = true;
  				if(cur == 0){
  					cur = (cnt2 + 1) * n / cnt1;
  					cur2 = (cnt2 + 1) * n % cnt1;
  					flag = false;
  				}
				
				System.out.println("Possible");
				int ans = 0;
					for(int i = 0 ; i < len ; i ++){
						if(i == 0){
							if(ans < cur2){
								System.out.print((cur + 1) +" ");
							}else{
								System.out.print(cur +" ");
							}
							ans ++;
							// System.out.print(cur2 +" ");
							continue;
						}
						if(i == len - 1){
							System.out.println(n);
							continue;
						}
						if(a[i].equals("?")){
							if(a[i-1].equals("+")){
								if(ans < cur2){
								System.out.print((cur + 1) +" ");
								}else{
									System.out.print(cur +" ");
								}
								ans ++;
							}else{
								if(flag)
									System.out.print(1+" ");
								else
									System.out.print(n+" ");
							}
						}else{
							System.out.print(a[i]+" ");
						}
					}
			}

		}
	}
}
