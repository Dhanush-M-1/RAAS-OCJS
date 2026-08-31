import java.util.Scanner;

public class test01 {
	public static void main(String[] argv) { 
		
		Scanner a = new Scanner(System.in);
		
		String b = a.nextLine();
		b = b.replace("+","");
		//System.out.println(b);
		int[] c = new int[b.length()];
		for(int x=0;x<b.length();x++){
			int d = Integer.parseInt(b.substring(x, x+1));
			c[x] = d;
		}
		
		int[] data = c; // 為排序的資料 
		int temp; // 用來交換元素的暫存變數 
		for (int i = 0; i < data.length - 1; i++) {
			for (int j = 0; j < data.length - 1 - i; j++) { 
				if (data[j] > data[j + 1]) { 
					temp = data[j]; 
					data[j] = data[j + 1]; 
					data[j + 1] = temp; 
				}
			}
		}
		String e = new String();
		for(int f=0;f<b.length();f++){
			e += "+";
			e += String.valueOf(data[f]);
		}
		e = e.substring(1);
		System.out.print(e); 
		a.close();
		} 
}