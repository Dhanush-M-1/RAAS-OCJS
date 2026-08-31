import java.util.*;

public class Main {

	char[] key;
	char[] cipher;

	void run(){
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while(T-- > 0){
			key = in.next().toCharArray();
			cipher = in.next().toCharArray();
			System.out.println(solve());
		}
	}

	String solve(){
		int M = cipher.length;
		for(int i=key.length-1; i>=0; i--){
			char[] tmp = new char[M];
			if(key[i] == 'J'){
				for(int j=0; j<M; j++){
					tmp[j] = cipher[(j+M-1)%M];
				}
			}
			else if(key[i] == 'C'){
				for(int j=0; j<M; j++){
					tmp[j] = cipher[(j+1)%M];
				}
			}
			else if(key[i] == 'E'){
				tmp = cipher.clone();
				for(int j=0; j<M>>1; j++){
					char t = tmp[j];
					tmp[j] = tmp[j+(M+1)/2];
					tmp[j+(M+1)/2] = t;
				}
			}
			else if(key[i] == 'A'){
				for(int j=0; j<M; j++){
					tmp[j] = cipher[M-j-1];
				}
			}
			else if(key[i] == 'P'){
				for(int j=0; j<M; j++){
					if(Character.isDigit(cipher[j])){
						tmp[j] = (char) ((cipher[j] - '0' + 9)%10 + '0');
					}
					else{
						tmp[j] = cipher[j];
					}
				}
			}
			else if(key[i] == 'M'){
				for(int j=0; j<M; j++){
					if(Character.isDigit(cipher[j])){
						tmp[j] = (char) ((cipher[j] - '0' + 1)%10 + '0');
					}
					else{
						tmp[j] = cipher[j];
					}
				}
			}
			cipher = tmp.clone();
		}
		return String.valueOf(cipher);
	}

	public static void main(String args[]){
		new Main().run();
	}
}