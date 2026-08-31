import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ES {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Scanner sc= new Scanner(System.in);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s1=in.readLine();
		String s2=in.readLine();
		if(eq(s1,s2)){
			System.out.println("YES");
		}
		else{
			System.out.println("NO");
		}
		
		
	}

	static boolean eq(String s1,String s2){
		if(s1.equals(s2)){
			return true;
		}
		if(s1.length()%2 == 0){
			int n1=s2.length()/2;
			return ((eq(s1.substring(0,n1),s2.substring( n1))&& eq(s1.substring( n1),s2.substring(0,n1))  || eq(s1.substring(0,n1),s2.substring(0, n1))&& eq(s1.substring(n1),s2.substring(n1))));
		}
			return false;
		
	}
 }
