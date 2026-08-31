import java.util.Scanner;

public class Example {
	
	public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String a = s.next();
        String res = "";
        int count1 = 0;
        int count2=0;
        int count3=0;
        for(int i = 0; i < a.length(); i++){
        	if(a.charAt(i)== '1')
        		count1++;
        	if(a.charAt(i)== '2')
        		count2++;
        	if(a.charAt(i)== '3')
        		count3++;        	
        }
        if(count1+count2+count3 <= 1)
        	res = a;
        else {
	        for(int i = 0; i < count1; i++){
	        	res +="1+";
	        }
	        for(int i = 0; i < count2; i++){
	        	res +="2+";
	        }
	        for(int i = 0; i < count3; i++){
	        	res +="3+";
	        }
	        res = res.substring(0,res.length()-1);
        }
        System.out.println(res);
	}
}