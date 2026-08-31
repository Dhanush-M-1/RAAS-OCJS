import java.util.ArrayList;
import java.util.Scanner;


public class C {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] in = sc.next().toCharArray();
		sc.close();
		
		ArrayList<Integer> sh = new ArrayList<Integer>();
		int counter = 0;
		for (int i = 0; i < in.length; i++) {
			
			if(in[i]=='(') counter ++;
			
			if(in[i]=='#') {
				
				
				if(counter == 0) {
					
					boolean ch = false;
					for (int j = 0; j < sh.size(); j++) {
						int g = sh.get(j);
						if(g!=1) {
							ch = true;
							sh.set(j, g-1);
							sh.add(1);
							break;
						}
					}
					
					if(!ch) {
						System.out.println(-1);
						return ;
					}
					
				} else {
					sh.add(counter);
					counter = 0;
				}
			}
			
			if(in[i]==')') {
				if(counter==0) {
					if(sh.size()==0) {
						System.out.println(-1);
						return ;
					} else {
						boolean ch = false;
						for (int j = sh.size()-1; j >-1; j--) {
							int g = sh.get(j);
							if(g!=1) {
								ch = true;
								sh.set(j, g-1);
								break;
							}
						}
						
						if(!ch) {
							System.out.println(-1);
							return;
						}
						
					}
				} else {
					counter--;
				}
			}
			
		}
		
		if(counter!=0) {
			System.out.println(-1);
		} else {
			for (int i = 0; i < sh.size(); i++) {
				System.out.println(sh.get(i));
			}
		}
		
		
	}

}
