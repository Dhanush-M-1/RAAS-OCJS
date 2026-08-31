#include<cstdio>
int main() {
	int A, B; scanf("%d%d", &A, &B);
	printf("%d\n", 1 <= A && A <= 9 && 1 <= B && B <= 9 ? A*B : -1 );
}