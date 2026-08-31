import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		// 整数の入力
		char[] input = sc.next().toCharArray();
		char[] keyence = {'k', 'e', 'y', 'e', 'n', 'c', 'e', '_'};
		int select_keyence = 0;
		int wrong_char=-1;
		int after_wrong_char=0;
		boolean char_flag=true;
		boolean flag = true;
		String ans;
		for(int i=0; i<input.length; i++){

			if (input[i]!=keyence[select_keyence]){
				if(!char_flag && select_keyence==7){
					select_keyence = after_wrong_char;
					if(input[i]==keyence[select_keyence]){
						select_keyence++;
					}
					
				}
				if(char_flag){
					char_flag = false;
					after_wrong_char = select_keyence;
				}
				if (i-wrong_char>1){
					select_keyence = after_wrong_char;
					if(input[i]==keyence[select_keyence]){
						select_keyence++;
					}
				}
				wrong_char=i;
			}else{
				select_keyence++;
			}
			/*
			System.out.println("select_keyence:"+select_keyence);
			System.out.println("wrong_char:"+wrong_char);
			System.out.println("after_wrong_char:"+after_wrong_char);
			 */
		}
		if(!(select_keyence==7))flag=false;
		
		if(!flag){
			ans = "NO";
		}else{
			ans ="YES";
		}
		
		System.out.println(ans);
	}
}
