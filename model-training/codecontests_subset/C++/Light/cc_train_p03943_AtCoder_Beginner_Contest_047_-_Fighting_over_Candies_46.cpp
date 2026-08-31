#include <iostream>
int a, b, c;
int main() {
	std::cin>>a>>b>>c;
	std::cout<<(a==b+c || b==a+c || c==a+b ? "Yes":"No");
	return 0;
}