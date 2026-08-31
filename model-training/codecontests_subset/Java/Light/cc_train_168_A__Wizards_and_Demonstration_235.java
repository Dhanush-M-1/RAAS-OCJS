import java.util.Scanner;

public class WizardsDemonstration {
public static void main(String[] args) {
	Scanner scan=new Scanner(System.in);
int n=scan.nextInt();
int x=scan.nextInt();
int y=scan.nextInt();
long g=(long) Math.ceil(n*y*.01)-x;
System.out.println(g>0?g:0);
}

}
