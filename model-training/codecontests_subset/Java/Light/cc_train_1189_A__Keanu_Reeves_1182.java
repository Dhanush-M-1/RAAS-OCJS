import java.util.Scanner;

public class keanu_reeves {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner s = new Scanner(System.in);
int t=s.nextInt();
String st= s.next();

int c1=0;
int co=0;
for(int i=0;i<st.length();i++)
{
	if(st.charAt(i)=='1')
		c1+=1;
}
co=st.length()-c1;
if(co!=c1)
{
	System.out.println(1);
	System.out.println(st);
}
else
{
	System.out.println(2);
	
	System.out.println(st.substring(0,1)+" "+st.substring(1,st.length()));
}
	}

}
