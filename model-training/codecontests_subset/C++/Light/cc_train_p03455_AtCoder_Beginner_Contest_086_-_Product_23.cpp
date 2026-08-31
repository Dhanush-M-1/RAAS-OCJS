#include<cstdio>
int main()
{
int a, b;
scanf("%d%d", &a, &b);
if ((a * b) & 1)
puts("Odd");
else
puts("Even");
return 0;
}