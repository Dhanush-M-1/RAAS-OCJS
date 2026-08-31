#include<stdio.h>
#include<string.h>
int main()
{
int a,n;
int f[13][4];
int i,j;
char b;
for(i=0;i<13;i++) for(j=0;j<4;j++) f[i][j]=0;
scanf("%d",&n);
for(i=1;i<=n;i++)
{
scanf(" %c %d",&b,&a);
if(b=='S') f[a-1][0]=1;
if(b=='H') f[a-1][1]=1;
if(b=='C') f[a-1][2]=1;
if(b=='D') f[a-1][3]=1;
}
for(i=0;i<4;i++) 
{
for(j=0;j<13;j++) 
{
if(f[j][i]==0) 
{
if(i==0) printf("S %d\n",j+1); 
else if(i==1) printf("H %d\n",j+1); 
else if(i==2) printf("C %d\n",j+1); 
else if(i==3) printf("D %d\n",j+1);
}
}
}
return 0;
}