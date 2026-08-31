import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner stdIn = new Scanner(System.in);

		int rectangle = 0;//長方形
		int diamond = 0;//菱形
		List<String> dataList = new ArrayList<String>();
		while(stdIn.hasNext()){
			dataList.add(stdIn.next());
		}
		for(String i:dataList){
			String[] dataString = i.split(",");
			int dataInt0 = Integer.valueOf(dataString[0]);
			int dataInt1 = Integer.valueOf(dataString[1]);
			int dataInt2 = Integer.valueOf(dataString[2]);
			if(dataInt0 == dataInt1){
				diamond++;
			}else if(dataInt0 * dataInt0 + dataInt1 * dataInt1 == dataInt2 * dataInt2){
				rectangle++;
			}
		}
		System.out.println(rectangle + "\n" + diamond);
	}
}