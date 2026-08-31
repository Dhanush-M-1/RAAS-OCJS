import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

        Scanner cin=new Scanner(System.in);
        String a = cin.nextLine();

        int max = 0;
        int now = 0;

        for(int i = 0; i < a.length(); i++){
        	if(a.charAt(i) == 'T'){
        		now++;
        		if(now >= max){
        			max = now;
        		}
        	}else{
        		now--;
        	}
        }
        System.out.println(max * 2);
	}

}