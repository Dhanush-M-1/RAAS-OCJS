import java.io.PrintStream;
import java.util.Scanner;

public class ABtpTest {

	public static void main(String[] args) {
		PrintStream p = System.out;
		Scanner sc =new Scanner(System.in);
		try{
			int l = sc.nextInt();
			int r = sc.nextInt();
			if(l == r)p.println(l);
			else{
				p.println(2);
			}

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			sc.close();
			p.close();
		}
	}
	
}