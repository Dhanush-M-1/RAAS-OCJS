import java.util.Scanner;


public class A {
	
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		int n = input.nextInt();
		String s = input.next();

		int c = 0;
		
		
		while(s.indexOf('*') != -1){
			int q = s.indexOf('*');
			s = s.substring(q);
			String t = s;
			
			//System.out.println(s);
			//System.out.println(q);
			
			for(int i = 1; i < t.length(); i++){
				c = 0;
				if(t.charAt(i) == '*'){
					int r = i;
					String p = t;
					for(int j = 0; j < 5; j++){
						if(j*r < p.length())
							if(p.charAt(j*r) == '*')
								c++;
						//System.out.println(c);
					}
					if(c == 5){
						System.out.println("yes");
						System.exit(0);
					}
						
				}
			}
			s = s.substring(1);
		}
		
		System.out.println("no");
		
		input.close();
	}

}
