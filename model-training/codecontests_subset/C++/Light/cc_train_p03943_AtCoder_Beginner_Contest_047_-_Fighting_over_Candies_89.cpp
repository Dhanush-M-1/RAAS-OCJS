#include<cstdio>

int a, b, c;
int main() {
	scanf("%d %d %d", &a, &b, &c);
	if (a == b + c || b == a + c || c == a + b)  printf("%s", "Yes");
	else printf("%s", "No");
	return 0;
}