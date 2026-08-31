import java.util.Scanner;
public class Main {
public static void main(String args[]) {
Scanner cro=new Scanner(System.in);
int N,M,i,j,delx,dely,min;
N=cro.nextInt();
M=cro.nextInt();
int students[][]=new int[N][3];
int checkpoints[][]=new int[M][2];
for(i=0;i<N;i++)
{
students[i][0]=cro.nextInt();
students[i][1]=cro.nextInt();
}
for(i=0;i<M;i++)
{
checkpoints[i][0]=cro.nextInt();
checkpoints[i][1]=cro.nextInt();
}
for(i=0;i<N;i++)
{
delx=students[i][0]-checkpoints[0][0];
dely=students[i][1]-checkpoints[0][1];
if(delx<0) delx=-delx;
if(dely<0) dely=-dely;
min=delx+dely;
students[i][2]=1;
for(j=1;j<M;j++)
{
delx=students[i][0]-checkpoints[j][0];
dely=students[i][1]-checkpoints[j][1];
if(delx<0) delx=-delx;
if(dely<0) dely=-dely;
if(delx+dely<min)
{
min=delx+dely;
students[i][2]=j+1;
}
}
}
for(i=0;i<N;i++) System.out.println(students[i][2]);
}
}