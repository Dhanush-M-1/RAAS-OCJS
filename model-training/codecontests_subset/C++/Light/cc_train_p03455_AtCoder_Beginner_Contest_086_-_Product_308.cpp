#include <stdio.h>

int main() {
	int a, b;

	scanf("%d %d", &a, &b);

	printf(a % 2 != 0 && b % 2 != 0 ? "Odd\n" : "Even\n");

	return 0;
}