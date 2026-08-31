#include<stdio.h>
int main( )
{
    int i, j;

    scanf("%d %d", &i, &j);
    printf("%s\n", i * j % 2 ? "Odd" : "Even");

    return 0;
}
