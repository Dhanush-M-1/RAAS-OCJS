
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution{

	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int num=0;
		int countpos=0;
		int countneg=0;
		for(int i=0;i<s.length();i+=4){
			if(i == 0){
				countpos++;
				continue;
			}

			if(s.charAt(i) =='?' && s.charAt(i-2) =='+')
				countpos++;
			else if(s.charAt(i) =='?' && s.charAt(i-2) == '-')
				countneg++;
			else if(s.charAt(i-2) =='='){
				num = Integer.parseInt(s.substring(i));
			}	
		}
		int max_terms =  countpos*num - num;
		int a=1;
		if((countneg == 0 && countpos > num) || countneg > max_terms)
			System.out.println("Impossible");
		else {

			//System.out.println(countneg + " " + countpos);
			int sum = num + countneg;
			if(sum < countpos){
				a =(int) Math.ceil((countpos-num)*1.0/(1.0*countneg));
				//	 System.out.println(a);
				sum = a*countneg + num; 
			}
			//System.out.println(sum);
			int comm = sum/countpos;
			int add = sum % countpos;

			if(comm == 0 || a > num){
				System.out.println("Impossible");
			}
			else{
				System.out.println("Possible");
				//System.out.println(comm +" " + add);
				for(int i=0;i<s.length();i++){
					if(i == 0){
						if(add > 0){
							System.out.print((comm+1));
							add--;
						}else System.out.print(comm);
						continue;
					}

					if(s.charAt(i) =='?' && s.charAt(i-2) =='+'){
						if(add > 0){
							System.out.print((comm+1));
							add--;
						}else System.out.print(comm);
					}

					else if(s.charAt(i) =='?' && s.charAt(i-2) == '-'){
						System.out.print(a);
					}
					else {
						System.out.print(s.charAt(i));
					}
				}
			}
		}
	}
}
