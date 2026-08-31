import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int rec=0,rho=0;
		int a,b,d;
		String str;
		try{
			while((str=br.readLine())!=null&&!str.isEmpty()){
				String[] s=str.split(",");
				a=Integer.parseInt(s[0]);
				b=Integer.parseInt(s[1]);
				d=Integer.parseInt(s[2]);
				if(a*a+b*b==d*d) rec++;
				else if(a==b) rho++;
			}
			System.out.println(rec+"\n"+rho);
		}catch(Exception e){
			System.out.println("Input Error");
		}
	}
}