import java.util.Scanner;

class Main {
    public static Boolean PrimeCheck(int x){
	for(int i=2; i<=Math.sqrt(x);i++){
	    if(x%i==0){
		return false;
	    }
	}
	return true;
    }
     public static void main(String[] args) {
	 Scanner sc = new Scanner(System.in);
	 int n = sc.nextInt();
	 int count = 0;
	 for(int i=0;i<n;i++){
	     int x = sc.nextInt();
	     if(PrimeCheck(x)){
		 count++;
	     }
	 }
	 System.out.println(count);
     }
    
}

