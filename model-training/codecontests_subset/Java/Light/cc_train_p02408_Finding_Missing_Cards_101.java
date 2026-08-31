import java.io.*;
import java.util.*;

class Main{
	public static void main(String args[])throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<String> list = new ArrayList<String>();

		//??¨????????????????????????
		for(int i=1; i<=13; i++){
			list.add("S " + i);
		}
		for(int i=1; i<=13; i++){
			list.add("H " + i);
		}
		for(int i=1; i<=13; i++){
			list.add("C " + i);
		}
		for(int i=1; i<=13; i++){
			list.add("D " + i);
		}

		int num = Integer.parseInt(br.readLine());
		for(int i=0; i<num; i++){
			int a = list.indexOf(br.readLine());
			list.remove(a);
		}

		for(String card: list){
			System.out.println(card);
		}
	}
}