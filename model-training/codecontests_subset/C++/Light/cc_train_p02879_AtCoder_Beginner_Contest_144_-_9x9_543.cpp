#include<stdio.h>
int main()
{
  int A,B;
  scanf("%d %d", &A, &B);
  printf("%d", (A < 10 && B < 10) ? A * B : -1);
  return 0;
}