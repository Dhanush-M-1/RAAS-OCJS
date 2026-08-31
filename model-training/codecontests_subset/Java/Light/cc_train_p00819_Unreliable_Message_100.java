import java.util.*;

class Main{
	static Scanner s=new Scanner(System.in);
	public static void main(String[] $){
		int n=s.nextInt();
		for(int q=0;q<n;++q) {
			String m=s.next();
			StringBuilder v=new StringBuilder(s.next());
			for(int i=m.length()-1;i>=0;--i) {
				switch(m.charAt(i)) {
				case 'J':
					v.insert(0,v.charAt(v.length()-1)).deleteCharAt(v.length()-1);
					break;
				case 'C':
					v.append(v.charAt(0)).deleteCharAt(0);
					break;
				case 'E':
					String t=v.substring(0,v.length()/2);
					String u=v.substring(v.length()-v.length()/2,v.length());
					v.replace(0,v.length()/2,u);
					v.replace(v.length()-v.length()/2,v.length(),t);
					break;
				case 'A':
					v.reverse();
					break;
				case 'P':
					for(int j=0;j<v.length();++j) {
						char c=v.charAt(j);
						if(Character.isDigit(c))
							v.setCharAt(j,(char)((c-'0'+9)%10+'0'));
					}
					break;
				case 'M':
					for(int j=0;j<v.length();++j) {
						char c=v.charAt(j);
						if(Character.isDigit(c))
							v.setCharAt(j,(char)((c-'0'+1)%10+'0'));
					}
					break;
				}
			}
			System.out.println(v);
		}
	}
}
