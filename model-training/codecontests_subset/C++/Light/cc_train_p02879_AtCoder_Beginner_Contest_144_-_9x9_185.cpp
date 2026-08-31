#include<stdio.h>
int main(){
  int a,b;
  scanf("%d",&a);
  scanf("%d",&b);
  if(a<=9&&b<=9) printf("%d\n",a*b);
  else printf("%d\n",-1);
}