import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		
		for(;;) {
			int input_num = sc.nextInt();
			if(input_num == 0) break;
			int count = 0;
			List<String> step_list = new ArrayList<String>();
			for(int i = 0; i < input_num; i++) {
				step_list.add(sc.next());
			}
			
			for(int i =0; i < input_num-1; i++) {
				String step = step_list.get(i);
				switch(step) {
					case "lu":
						if(step_list.get(i+1).equals("ru")) count++;
						break;
					case "ru":
						if(step_list.get(i+1).equals("lu")) count++;
						break;
					case "ld":
						if(step_list.get(i+1).equals("rd")) count++;
						break;
					case "rd":
						if(step_list.get(i+1).equals("ld")) count++;
						break;
				}
			}
			System.out.println(count);
		}
	}
}

