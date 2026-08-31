import java.util.*;
public class b {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	String s = sc.nextLine();
	if(s.charAt(0)=='#'){
		System.out.println("-1");
		sc.close();
		return;
	}
	int arr[] = new int[s.length()];
	int numhash =0;
	arr[0] = s.charAt(0)=='(' ? 1:-1;
	for(int i=1;i<s.length();i++){
		if(s.charAt(i)=='#')numhash++;
		if(s.charAt(i)=='(')
			arr[i]=arr[i-1]+1;
		else
			arr[i]=arr[i-1]-1;
	}
//	System.out.println(Arrays.toString(arr));
	int hashes[]= new int [numhash];
	boolean check=true;
	int c =0;
	for(int i=0;i<s.length();i++){
		if(s.charAt(i)=='#')
		{
			hashes[c]=i;
			c++;
		}
		if(arr[i]<0){
			check = false;
			break;
		}
		
	}
	if(!check){
		System.out.println("-1");
		sc.close();
		return;
	}else{
		int as = arr[arr.length-1];
		for(int i = hashes[hashes.length-1];i<arr.length;i++){
			arr[i]-=as;
			if(arr[i]<0){
				System.out.println("-1");
				sc.close();
				return;
			}
		}
		for(int i=0;i<hashes.length-1;i++){
			System.out.println("1");
		}
		System.out.println((as+1));
	}
	sc.close();
}
}
