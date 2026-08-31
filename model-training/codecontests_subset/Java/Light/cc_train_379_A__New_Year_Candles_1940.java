import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Scanner akash = new Scanner(System.in);
	    int total=akash.nextInt();
	    int creat_with = akash.nextInt();
		int reminder = 0,temp1 = 0;
	    int ans = 0;

	    if(total < creat_with){
	    	ans = total;
		}
		else{
			ans = total;
			while(total >= creat_with){
				temp1 = (total / creat_with);
				reminder = (total % creat_with);
				ans+= temp1;
				total = temp1+reminder;
			}
		}
	    System.out.println(ans);
	    akash.close();
    }
}