#include <stdio.h>
int main(void){
  int a,b,c;
  scanf("%d%d%d",&a,&b,&c);
  printf("%s\n",(b+c==a||c+a==b||a+b==c)? "Yes":"No");
  return 0;
}