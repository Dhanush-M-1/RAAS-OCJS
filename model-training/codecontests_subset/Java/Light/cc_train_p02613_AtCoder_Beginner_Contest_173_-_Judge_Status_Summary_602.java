import java.util.Scanner;

class Main{
      public static void main(String args[]){
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	int[] count = new int[4];
	for(int i=0;i<n;i++){
	    String str = sc.next();
	    if(str.equals("AC")){
		count[0]++;
	    }else if(str.equals("WA")){
		count[1]++;
	    }else if(str.equals("TLE")){
		count[2]++;
	    }else{
		count[3]++;
	    }
	}
	System.out.println("AC x "+count[0]);
	System.out.println("WA x "+count[1]);
	System.out.println("TLE x "+count[2]);
	System.out.println("RE x "+count[3]);
	sc.close();
      }
}
