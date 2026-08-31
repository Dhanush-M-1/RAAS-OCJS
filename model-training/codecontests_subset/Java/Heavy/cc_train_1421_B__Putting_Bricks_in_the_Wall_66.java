import java.util.*;

public class b{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0){
			int n = s.nextInt();
			String arr[] = new String[n];
			for(int i=0;i<n;i++){
				arr[i] = s.next();
			}
			char ch1 = arr[0].charAt(1);
			char ch2 = arr[1].charAt(0);
			char ch3 = arr[n-2].charAt(n-1);
			char ch4 = arr[n-1].charAt(n-2);
			if(ch1==ch2){
				if(ch1=='1'){
					if(ch3==ch4){
						if(ch3=='1'){
						System.out.println(2);
						System.out.println(n+" "+(n-1));
						System.out.println((n-1)+" "+(n));
					}else{
						System.out.println(0);
					}
					}else if(ch3=='1'){
						System.out.println(1);
						System.out.println((n-1)+" "+(n));
					}else{
						System.out.println(1);
						System.out.println((n)+" "+(n-1));
					}
				}else{
					if(ch3==ch4){
						if(ch3=='0'){
						System.out.println(2);
						System.out.println(n+" "+(n-1));
						System.out.println((n-1)+" "+(n));
					}else{
						System.out.println(0);
					}
					}else if(ch4=='0'){
						System.out.println(1);
						System.out.println(n+" "+(n-1));
					}else{
						System.out.println(1);
						System.out.println((n-1)+" "+(n));
					}
				}
			}else{
				if(ch3==ch4){
					if(ch3=='1'){
						if(ch1=='1'){
							System.out.println(1);
							System.out.println("1 2");
						}else{
							System.out.println(1);
							System.out.println("2 1");
						}
					}else{
						if(ch1=='0'){
							System.out.println(1);
							System.out.println("1 2");
						}else{
							System.out.println(1);
							System.out.println("2 1");
						}
					}
				}else{
					if(ch1=='1'){
						System.out.println(2);
						System.out.println("1 2");
					}else{
						System.out.println(2);
						System.out.println("2 1");
					}

					if(ch3=='0'){
						System.out.println((n-1)+" "+(n));
					}else{
						System.out.println((n)+" "+(n-1));
					}
				}
			}
		}
	}
}