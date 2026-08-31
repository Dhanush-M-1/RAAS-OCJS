#include<stdio.h>

int main(){

int n;

scanf("%d",&n);
int x;
for(int i=0;i<n;i++)
{scanf("%d",&x);
int c=0;int d=10;int w=0,y=0;int max=0;
while(x/10!=0){
for(int j=0;j<6;j++)
{
w=x/d;y=x%d;d*=10;
if(j==0)max=w*y;
else if(w*y>max)max=w*y;}
x=max;c++;d=10;}
printf("%d\n",c);
}
return 0;
}