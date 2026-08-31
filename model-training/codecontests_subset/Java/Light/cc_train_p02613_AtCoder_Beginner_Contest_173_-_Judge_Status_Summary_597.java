import java.util.*;
class Main {
	public static void main(String[] abcdefg) {
		Scanner sc=new Scanner(System.in);
		List<String>list=new ArrayList<>();
		int n=sc.nextInt();
		for(int i=0;i<n;i++)
			list.add(sc.next());
		
			int ac=0,wa=0,tle=0,re=0;
		for(int i=0;i<n;i++){
			if(list.get(i).equals("AC")){
				ac++;
			}
			else if(list.get(i).equals("WA")){
				wa++;
			}
			else if(list.get(i).equals("TLE")){
				tle++;
			}
			else{
				re++;
			}
		}	
		System.out.print("AC x "+ac+"\n");
		System.out.print("WA x "+wa+"\n");
		System.out.print("TLE x "+tle+"\n");
		System.out.print("RE x "+re+"\n");
		sc.close();
		   
	}
}

