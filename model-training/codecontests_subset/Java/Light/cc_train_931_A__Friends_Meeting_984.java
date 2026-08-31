import java.io.*;
import java.util.*;
public class FriendsMeeting {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Scanner lect=new Scanner(System.in);

		int n1=lect.nextInt();
		int n2=lect.nextInt();

		int tot=Math.abs(n1-n2);
		
		int res=tot/2;
		int minus=tot-res;
		
		int cont1=0;
	
		for (int i = 1; i <= minus; i++) 
			cont1+=i;
		
		
		int cont2=0;

		for (int i = 1; i <= res; i++) 
			cont2+=i;
			
		System.out.println(cont1+cont2);
		
	}

}
