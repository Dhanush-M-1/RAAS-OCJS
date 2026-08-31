#include<iostream>
int main() {
	int a, b;
	std::cin >> a >> b;
	int A = a*b;
		if (A% 2 == 0) puts("Even");
		else puts("Odd");
		return 0;
}