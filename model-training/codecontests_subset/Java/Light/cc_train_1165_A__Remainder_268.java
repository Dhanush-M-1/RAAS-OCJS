

import java.util.Scanner;

public class Input {

	public static void main(String[] args) {
		
		
		Scanner scan = new Scanner(System.in);
                int digits = scan.nextInt();
                int modulo = scan.nextInt();
                int remainder = scan.nextInt();
                scan.nextLine();
                 
                String number = scan.nextLine();
                
                //if(number.charAt(digits-modulo-1)!='1')counter++;
                
                String modnum=number.substring(digits-modulo); 
                int index=modulo-remainder-1;
                 int counter = ((modnum.charAt(index) == '1') ? -1 : 1);
                for (int i=0;i<modnum.length();i++){
                    if (modnum.charAt(i)=='1')counter++;
                    
                }
                
                
                
                
                
                
                System.out.println(counter);
                
        }}