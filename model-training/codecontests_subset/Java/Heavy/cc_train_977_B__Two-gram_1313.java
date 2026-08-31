import java.util.*;
public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
			
		int n = sc.nextInt();
		sc.nextLine();
		
		String s = sc.nextLine();
		String ans = "";
		int max =0;
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		for (int i =0;i<n-2;i++) {
			String two = String.valueOf(s.charAt(i))+String.valueOf(s.charAt(i+1));
			if (!map.containsKey(two)) {
				int count =1;
				for (int j = i+1;j<n-1;j++) {
					String temp = String.valueOf(s.charAt(j))+String.valueOf(s.charAt(j+1));
					if (two.equals(temp))
						count++;
				}
				
				if (count>max) {
					max = count;
					ans = two;
				}
			}
			
		}
		if (n==2)
			ans = s;
		System.out.println(ans);
		sc.close();

	}

}
