import java.util.*;

public class Main{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		Map<String, Boolean> map = new LinkedHashMap<>();
		String image = null;
		for(int i = 0;i < 4; i++){
			switch(i){
				case 0:
					image = "S";
					break;
				case 1:
					image = "H";
					break;
				case 2:
					image = "C";
					break;
				case 3:
					image = "D";
					break;
			}
			for(int j = 1; j <= 13; j++){
				map.put(image + " " + String.valueOf(j), false);
			}
		}
		int n = sc.nextInt();
		for(int i = 0; i <= n; i++){
			map.put(sc.nextLine(), true);
		}
		for(String data: map.keySet()){
			if(!map.get(data)){
				System.out.println(data);
			}
		}
	}
}

