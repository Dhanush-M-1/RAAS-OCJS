import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		while(n-- > 0){
			String order = sc.next(), m = sc.next();
			int len = m.length();

			for(int i=order.length()-1;i>=0;i--){
				switch(order.charAt(i)){
				case 'J':
					m = m.substring(len-1) + m.substring(0,len-1);
					break;
				case 'C':
					m = m.substring(1) + m.substring(0,1);
					break;
				case 'E':
					if(len%2==0) m = m.substring(len/2) + m.substring(0,len/2);
					else m = m.substring(len/2+1) + m.substring(len/2,len/2+1) + m.substring(0,len/2);
					break;
				case 'A':
					m = new StringBuilder(m).reverse().toString();
					break;
				case 'P':
					String s = "";
					for(int j=0;j<len;j++){
						char c = m.charAt(j);
						if('0'<=c && c<='9'){
							if(c == '0') c = '9';
							else c--;
						}
						s += c;
					}
					m = s;
					break;
				case 'M':
					s = "";
					for(int j=0;j<len;j++){
						char c = m.charAt(j);
						if('0'<=c && c<='9'){
							if(c == '9') c = '0';
							else c++;
						}
						s += c;
					}
					m = s;
					break;
				}
			}
			System.out.println(m);
		}
	}
}