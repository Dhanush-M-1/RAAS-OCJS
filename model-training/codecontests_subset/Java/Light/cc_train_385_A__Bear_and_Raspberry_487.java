
import java.util.Scanner;


public class Main {

public static void main(String[] args) {
Scanner s= new Scanner (System.in);


int C=s.nextInt();
int R=s.nextInt();
int max=0;
int E[] = new int[C];
for (int i=0;i<C;i++)
{
	E[i]=s.nextInt();
}

for (int j=0;j<C-1;j++)
{
	if (E[j]-E[j+1]>max)
	{
		max=E[j]-E[j+1];
	}
}
if (max-R>0)
{
	System.out.println(max-R);
} else {
	System.out.println(0);
}
}}
