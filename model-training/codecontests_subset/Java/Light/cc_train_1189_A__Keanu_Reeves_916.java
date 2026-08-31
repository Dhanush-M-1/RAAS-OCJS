import java.util.*; 
public class g 
{ 
public static void main(String[] args) 
{
Scanner in=new Scanner(System.in); 
int n=in.nextInt(); 
String s=in.next();
int x=0;
for(int i=0;i<n;i++)
{ 
	if(s.charAt(i)=='0')
		x++;
}
if(x==(n-x))
{
	System.out.println(2);
	System.out.print(s.charAt(0)+" ");
for(int i=1;i<n;i++)
	System.out.print(s.charAt(i));
System.out.println();
}
else
{
	System.out.println(1);
	System.out.println(s);
}
}
}
