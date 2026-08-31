#include<stdio.h>
int main(){
	int A, B, C, max;
	scanf("%d %d %d",&A,&B,&C);
	max=(A>B)?A:B;
	max=(C>max)?C:max;
	if(max == A+B+C-max) printf("Yes");
	else printf("No");
}