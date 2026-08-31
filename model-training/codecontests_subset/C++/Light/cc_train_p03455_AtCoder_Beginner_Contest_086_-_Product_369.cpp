#include<cstdio>
long long a, b;
int main() {
	scanf("%lld %lld",&a,&b);
	printf("%s\n",a * b % 2 == 0 ? "Even" : "Odd");
}