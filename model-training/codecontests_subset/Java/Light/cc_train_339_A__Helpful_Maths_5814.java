import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		String str;
		Scanner scanner = new Scanner(System.in);
		int ans[] = new int[4];
		while(scanner.hasNext()){
			ans[1] = ans[2] = ans[3] = 0;
			str = scanner.nextLine();
			for(int i = 0;i < str.length();i++){
				if(str.charAt(i) != '+'){
					ans[str.charAt(i) - '0']++;
				}
			}
			StringBuffer stb = new StringBuffer();
			for(int i = 1;i <= 3;i++){
				for(int j = 0;j < ans[i];j++){
					if(stb.length() != 0){
						stb.append('+');
					}
					if(i == 1){
						stb.append('1');
					}
					else if(i == 2){
						stb.append('2');
					}
					else{
						stb.append('3');
					}
				}
			}
			System.out.println(stb);
		}
	}
}

		 	 	   	 	  	 	  				   	