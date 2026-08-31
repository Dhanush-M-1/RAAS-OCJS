import java.util.Scanner;

 
public class Wizards__and__Demonstration {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Scanner in=new Scanner(System.in);
     int n=in.nextInt();
     int x=in.nextInt();
     int y=in.nextInt();
     double h=n*y;
   //  System.out.println(h);
     double k=(double) Math.ceil((h/100));
    //System.out.println(k);
     if(k>=x)
     System.out.println((int)k-x);
     else System.out.println(0);
      
	}

}
