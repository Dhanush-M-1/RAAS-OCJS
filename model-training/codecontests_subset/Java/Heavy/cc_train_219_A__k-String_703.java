import java.util.Scanner;
public class kString{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int k = input.nextInt();
		String word = input.next();
		int[] letters = new int[26];
		for(char c: word.toCharArray()){
			letters[c-'a']++;
		}
		for(int i: letters){
			if(i%k != 0){
				System.out.println(-1);
				return;
			}
		}

		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < letters.length; i++){
			if(letters[i] != 0){
				for(int j = 0; j < letters[i]/k; j++) sb.append((char)(i+'a'));
			}
		}

		StringBuilder ans = new StringBuilder(sb.toString());
		for(int i = 1; i < k; i++){
			ans.append(sb.toString());
		}
		System.out.println(ans.toString());
	}
}

