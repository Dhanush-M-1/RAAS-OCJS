
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			int n=sc.nextInt();
			for(int i=0; i<n; i++) {
				String s=sc.next();
				String m=sc.next();
				int length=m.length();
				String m2="";
				for(int j=s.length()-1; j>=0; j--) {
					if(s.charAt(j)=='J') {
						for(int k=0; k<length; k++) {
							if(k==0) m2+=m.charAt(length-1);
							else m2+=m.charAt(k-1);
						}
						m=m2;
						m2="";
					}
					if(s.charAt(j)=='C') {
						for(int k=0; k<length; k++) {
							if(k==length-1) m2+=m.charAt(0);
							else m2+=m.charAt(k+1);
						}
						m=m2;
						m2="";
					}
					if(s.charAt(j)=='E') {
						if(length%2==1) {
							for(int k=length/2+1; k<length; k++) {
								m2+=m.charAt(k);
							}
							m2+=m.charAt(length/2);
							for(int k=0; k<length/2; k++) {
								m2+=m.charAt(k);
							}
						}else {
							for(int k=length/2; k<length; k++) {
								m2+=m.charAt(k);
							}
							for(int k=0; k<length/2; k++) {
								m2+=m.charAt(k);
							}
						}
						m=m2;
						m2="";
					}
					if(s.charAt(j)=='A') {
						for(int k=length-1; k>=0; k--) {
							m2+=m.charAt(k);
						}
						m=m2;
						m2="";
					}
					if(s.charAt(j)=='P') {
						for(int k=0; k<length; k++) {
							if(Character.isDigit(m.charAt(k))) {
								int num=m.charAt(k)-'0';
								num--;
								if(num<0) num=9;
								m2+=String.valueOf(num);
							}else {
								m2+=m.charAt(k);
							}
						}
						m=m2;
						m2="";
					}
					if(s.charAt(j)=='M') {
						for(int k=0; k<length; k++) {
							if(Character.isDigit(m.charAt(k))) {
								int num=m.charAt(k)-'0';
								num++;
								if(num>9) num=0;
								m2+=String.valueOf(num);
							}else {
								m2+=m.charAt(k);
							}
						}
						m=m2;
						m2="";
					}
				}
				System.out.println(m);
				
				
			}
			

		}
	}
}
