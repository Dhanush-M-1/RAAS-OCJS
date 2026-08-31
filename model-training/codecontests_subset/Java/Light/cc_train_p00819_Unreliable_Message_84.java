import java.io.*;
import java.util.*;

public class Main{
	final int INF = 1<<24;

	private void doit(){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while(n-- > 0){
			String human = sc.next();
			StringBuilder after = new StringBuilder( sc.next());
			int len = after.length();
			for(int i = human.length() - 1; i >= 0; i--){
				char nowhuman = human.charAt(i);
				char temp;
				switch(nowhuman){
				case 'J':
					//right
					temp = after.charAt(len-1);
					for(int j = len-1; j > 0; j--){
						after.setCharAt(j, after.charAt(j- 1));
					}
					after.setCharAt(0, temp);
					break;
				case 'C':
					//left
					temp = after.charAt(0);
					for(int j = 0; j < len-1; j++){
						after.setCharAt(j, after.charAt(j+ 1));
					}
					after.setCharAt(len-1, temp);
					break;
				case 'E':
					//swap
					for(int j = 0; (j + 1) * 2 <= len; j++){

						temp = after.charAt(j);
						after.setCharAt(j, after.charAt(j + (len + 1) / 2  ));
						after.setCharAt(j + (len + 1) / 2 , temp);
					}
					break;
				case 'A':
					//reverse
					after = new StringBuilder(after.toString()).reverse();
					break;
				case 'P':
					//decrease
					for(int j = 0; j < len; j++){
						temp = after.charAt(j);
						if(temp >= '0' && temp <= '9'){
							if(temp == '0') temp = '9';
							else temp--;
						}
						after.setCharAt(j, temp);
					}
					break;
				case 'M':
					//increase
					for(int j = 0; j < len; j++){
						temp = after.charAt(j);
						if(temp >= '0' && temp <= '9'){
							if(temp == '9') temp = '0';
							else temp++;
						}
						after.setCharAt(j, temp);
					}
					break;
				}
			}
			System.out.println(after.toString());
		}
	}

	public static void main(String [] args){
		new Main().doit();
	}
}