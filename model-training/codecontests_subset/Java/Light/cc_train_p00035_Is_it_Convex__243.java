import java.util.Scanner;
public class Main {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){
			String[] str=sc.next().split(",");
			double xa=Double.parseDouble(str[0]);
			double ya=Double.parseDouble(str[1]);
			double xb=Double.parseDouble(str[2]);
			double yb=Double.parseDouble(str[3]);
			double xc=Double.parseDouble(str[4]);
			double yc=Double.parseDouble(str[5]);
			double xd=Double.parseDouble(str[6]);
			double yd=Double.parseDouble(str[7]);
			boolean flag=true;
			double z1=(xc-xb)*(ya-yb)-(yc-yb)*(xa-xb);
			double z2=(xb-xd)*(ya-yd)-(yb-yd)*(xa-xd);
			double z3=(xc-xb)*(ya-yb)-(yc-yb)*(xa-xb);
			if(z1>0&&z2>0&&z3>0||z1<0&&z2<0&&z3<0){
				flag=false;
			}
			z1=(xd-xc)*(yb-yc)-(yd-yc)*(xb-xc);
			z2=(xc-xa)*(yb-ya)-(yc-ya)*(xb-xa);
			z3=(xd-xc)*(yb-yc)-(yd-yc)*(xb-xc);
			if(z1>0&&z2>0&&z3>0||z1<0&&z2<0&&z3<0){
				flag=false;
			}
			z1=(xa-xd)*(yc-yd)-(ya-yd)*(xc-xd);
			z2=(xd-xb)*(yc-yb)-(yd-yb)*(xc-xb);
			z3=(xa-xd)*(yc-yd)-(ya-yd)*(xc-xd);
			if(z1>0&&z2>0&&z3>0||z1<0&&z2<0&&z3<0){
				flag=false;
			}
			z1=(xb-xa)*(yd-ya)-(yb-ya)*(xd-xa);
			z2=(xa-xc)*(yd-yc)-(ya-yc)*(xd-xc);
			z3=(xb-xa)*(yd-ya)-(yb-ya)*(xd-xa);
			if(z1>0&&z2>0&&z3>0||z1<0&&z2<0&&z3<0){
				flag=false;
			}
			System.out.println(flag?"YES":"NO");
		}
	}
}