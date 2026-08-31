import java.util.*;
public class cf {
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int k=sc.nextInt();
		sc.nextLine();
		String s=sc.nextLine();
		int a[]=new int[26];
		boolean flag=false;
		for(int i=0;i<s.length();i++){
			a[s.charAt(i)-'a']++;
		}
		for(int i=0;i<a.length;i++){
			if(a[i]%k!=0){
				flag =true;break;
			}
		}
		if(flag) System.out.println(-1);
		else{
			String ans ="";
			for(int i=0;i<a.length;i++){
				for(int j=0;j<a[i]/k;j++){
					ans = ans+((char)('a'+i));
				}
			}
			for(int i=0;i<k;i++) System.out.print(ans);
		}

	}

}
