import java.util.Scanner;
class Main
{
 public static void main(String args[])
 {
  int number,i,j,n;
  String pattern;
  int [][] card = new int [4][13];
  for(i=0;i<4;i++)
  {
   for(j=0;j<13;j++)
    card[i][j]=0;
  }
  Scanner sc = new Scanner(System.in);
  n=sc.nextInt();
  for(i=0;i<n;i++)
  {
   pattern=sc.next();
   number=sc.nextInt();
   switch(pattern.charAt(0))
   {
    case 'S':
     card[0][number-1]=1;break;
    case 'H':
     card[1][number-1]=1;break;
    case 'C':
     card[2][number-1]=1;break;
    default:
     card[3][number-1]=1;break;
	}
  }
  for(i=0;i<4;i++)
  {
   for(j=0;j<13;j++)
   {
    if(card[i][j]!=1)
	{
      if(i==0)
       System.out.println("S "+(j+1));
      else if(i==1)
       System.out.println("H "+(j+1));
      else if(i==2)
       System.out.println("C "+(j+1));
      else
       System.out.println("D "+(j+1));
	 }
	}
   }
 }
}
