import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

class Main{
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(br.readLine());
		String[] str = new String[2];
		ArrayList<String> list = new ArrayList<String>();
		String dis;
		for(int n=0;n<4;n++){
			for(int m=1;m<=13;m++){
				switch(n){
				case 0:
					list.add("S "+ m);
					break;
				case 1:
					list.add("H "+ m);
					break;
				case 2:
					list.add("C "+ m);
					break;
				case 3:
					list.add("D "+ m);
					break;
				}
			}
		}
		for(int i=0; i<cnt; i++){
			str = br.readLine().split(" ");
			list.remove(list.indexOf(str[0] + " " + str[1]));
		}
		for(int i=0;i<list.size();i++){
			dis = list.get(i);
			System.out.println(dis);
		}
	}
}