import java.util.ArrayList;
import java.util.Scanner;

public class Solution{
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        ArrayList<String[]> sf = new ArrayList<String[]>();
        
        for(int i = 0; i<t; i++){
            int n = scanner.nextInt();
            String[] nm = new String[n];
            String kk = scanner.nextLine();
            for(int k = 0; k<n; k++){
            	nm[k] = scanner.nextLine();
            	//System.out.println(nm[k]);
            }
            sf.add(nm);
        }
        for(int i = 0; i<t; i++) {
        	find(sf.get(i));
        }
    }

	private static void find(String[] st) {
		// TODO Auto-generated method stub
		if(st[0].charAt(1) == st[1].charAt(0)) {
			if(st[st.length-1].charAt(st[0].length()-2) == st[st.length-2].charAt(st[0].length()-1)) {
				if(st[0].charAt(1) == st[st.length-2].charAt(st[0].length()-1)) {
					System.out.println("2");
					System.out.println("1 2");
					System.out.println("2 1");
				}
				else {
					System.out.println("0");
				}
			}
			else {
				if(st[0].charAt(1) == st[st.length -2].charAt(st[0].length() -1)) {
					System.out.println("1");
					System.out.println((st.length-1) + " "+ st[0].length());
				}
				else {
					System.out.println("1");
					System.out.println(st.length + " " + (st[0].length()-1));
				}
			}
		}
		else {
			if(st[st.length-1].charAt(st[0].length()-2) == st[st.length-2].charAt(st[0].length()-1)) {
				if((st[0].charAt(1) == st[st.length-2].charAt(st[0].length()-1))) {
					System.out.println("1");
					System.out.println("1 2");
				}
				else {
					System.out.println("1");
					System.out.println("2 1");
				}
			}
			else {
				if(st[0].charAt(1) == st[st.length -2].charAt(st[0].length() -1)) {
					System.out.println("2");
					System.out.println("1 2");
					System.out.println(st.length + " "+ (st[0].length()-1));
				}
				else {
					System.out.println("2");
					System.out.println("1 2");
					System.out.println((st.length-1) + " " + (st[0].length()));
				}
			}
		}
		
	}
    
}