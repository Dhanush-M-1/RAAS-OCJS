import java.util.Scanner;

public class ProbA {

	static boolean foundInversion = false;
	static int l=0;
	static int r=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int length =  sc.nextInt();
		String str = sc.next();
		
	
		
		findInversion(str,0,length-1);
		if(foundInversion) {
			System.out.println("YES");
			System.out.println(l+" "+r);
		}else {
			System.out.println("NO");
		}
	}
	
	
	public static void findInversion(String str,int start, int end) {
		if(start<end) {
			
			int mid = start + (end-start)/2;
			findInversion(str,start,mid);
			findInversion(str,mid+1,end);
			if(!foundInversion)
			mixHalves(str,start,mid+1,end);
		}
		
		
	}
	
	public static void mixHalves(String str,int start,int mid, int end) {
		int temp = mid-1;
		
		while(start<=temp && mid<=end) {
			//System.out.println(str.charAt(start)+" "+str.charAt(mid));
			if(str.charAt(start)>str.charAt(mid)) {
				foundInversion=true;
				l = start+1;
				r = mid+1;
				break;
			}
			else {
				start++;
			}
			
		}
	}

}
