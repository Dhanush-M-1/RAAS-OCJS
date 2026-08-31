import java.util.Scanner;
public class FakeND {
    public static void main(String[]args){
        Scanner kbd = new Scanner(System.in);
        String input= kbd.nextLine();
		String[] inputArray = input.split(" ");
        long l =Long.parseLong(inputArray[0]);
        long r =Long.parseLong(inputArray[1]);

		if (l==r){
        	System.out.println(l);
        	System.exit(0);
        }
        int[] divisor= new int [3];
        
        //divisor[0] is for 2, divisor[1] is for 3, divisor[2] is for 5
        for (long s=l; s <=r; s++){
        	if (s>1000000){
        		System.out.println("2");
        		System.exit(0);
        	}
            if (s%2==0){
                divisor[0]++;
            }
            if (s%3==0){
                divisor[1]++;
            } 
            if (s%5==0){
                divisor[2]++;
            }
        }
        if ((divisor[0]>divisor[1] && divisor[0]>divisor[2] ) || divisor[0]==divisor[2]){
            System.out.println("2");
        } else if ((divisor[1]>divisor[0] && divisor[1]>divisor[2]) || divisor[0]==divisor[1] ){
            System.out.println(3);
        }else System.out.println(5);

    }
}
