#include<stdio.h>

int n,m,a[100001],d[100001],t;

int main(){
  scanf("%d%d",&n,&m);
  for(int i=0;i<m;i++){
    scanf("%d",&t);
    a[t]=1;
  }
  if(a[0]){
    putchar('0');
    return 0;
  }
  d[0]=1;
  if(!a[1])d[1]=1;
  for(int i=2;i<=n;i++)if(!a[i])d[i]=(d[i-1]+d[i-2])%1000000007;
  printf("%d",d[n]);
  return 0;
}