import java.util.*;

public class test{


public static void main(String[] args) {
	int[][]farbenArray;

	Scanner s = new Scanner (System.in);
	int n= Integer.parseInt(s.next());
	farbenArray = new int[n][2];
	for(int i=0;i<n;i++) {
		String str = s.next();
		String str2 = s.next();
		int stInt = Integer.parseInt(str);
		int stInt2 = Integer.parseInt(str2);
		farbenArray[i][0]=stInt;
		farbenArray[i][1]=stInt2;
//		int counter =0;
//		while(!(str.charAt(counter)==' ')) {
//			farbenArray[i][0]=str.charAt(counter);
//			counter+=1;
//		}
//		counter+=1;
//		while(counter<=(str.length()-1)) {
//			farbenArray[i][1]=str.charAt(counter);
//			counter+=1;
//		}
	}
	//theMethod(n);
	int output=0;
	for(int i=0;i<n;i++) {
		for(int j=0;j<n;j++) {
			if(farbenArray[i][0]==farbenArray[j][1]) {
				output+=1;
			}
		}
	}
	System.out.println(output);	
	}

//public static void theMethod(int n) {
//	int output=0;
//	for(int i=0;i<n;i++) {
//		for(int j=0;j<n;j++) {
//			if(farbenArray[i][0]==farbenArray[j][1]) {
//				output+=1;
//			}
//		}
//	}
//	System.out.println(output);
//}

}