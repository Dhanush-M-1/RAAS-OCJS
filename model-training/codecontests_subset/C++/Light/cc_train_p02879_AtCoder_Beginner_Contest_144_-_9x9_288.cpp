#include<stdio.h>

int main(){
  int A,B;
  scanf("%d%d",&A,&B);
  printf("%d",(A>9||B>9)?-1:A*B);
  return 0;
}