import java.util.*; public class wizards
{ public static void main(String[] args)
{ Scanner in=new Scanner(System.in);
int n=in.nextInt(),x=in.nextInt(),y=in.nextInt();
System.out.println(result(n,x,y));
}
public static int result(int n, int x,int y)
{ int p=(int)Math.ceil((double)(n*(y/100.0)));
if(p>x)
return (p-x);
else return (0);
}
}