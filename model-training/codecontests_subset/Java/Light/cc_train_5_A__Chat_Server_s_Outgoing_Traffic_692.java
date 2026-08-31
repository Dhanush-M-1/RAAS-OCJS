import java.util.Scanner;




public class Chat {
public static void main(String[] arg){
Scanner reader=new Scanner(System.in);
	int num=0;
	int sum=0;

	while(reader.hasNext()){
		String str=reader.nextLine();
	if(str.charAt(0)=='+'){
		num++;
	}	
	else if(str.charAt(0)=='-'){
		num--;
	}	
	else

		
	sum+=(str.length()-1-str.indexOf(':'))*num;
	}

	
	
	

	
	System.out.println(sum);	
}
}