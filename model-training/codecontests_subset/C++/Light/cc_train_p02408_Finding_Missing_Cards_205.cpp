#include<cstdio>
#include<cstring>
 
int main(){
bool b[4][13];
int i,n,m;
char c;
memset(b,1,sizeof(b));
scanf("%d",&n);
for(i=0;i<n;i++){
scanf(" %c %d",&c,&m);
if(c=='S')b[0][m-1]=false;
if(c=='H')b[1][m-1]=false;
if(c=='C')b[2][m-1]=false;
if(c=='D')b[3][m-1]=false;
}
 
for(i=0;i<13;i++)if(b[0][i])printf("S %d\n",i+1);
for(i=0;i<13;i++)if(b[1][i])printf("H %d\n",i+1);
for(i=0;i<13;i++)if(b[2][i])printf("C %d\n",i+1);
for(i=0;i<13;i++)if(b[3][i])printf("D %d\n",i+1);

scanf("%d",&n);

return 0;
 
}