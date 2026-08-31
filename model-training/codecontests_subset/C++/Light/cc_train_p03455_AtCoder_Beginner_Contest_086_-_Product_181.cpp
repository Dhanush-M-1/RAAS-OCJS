#include <iostream>
using namespace std;
int a, b;
int main() {
	cin>>a>>b;
	cout<<(a*b%2 ? "Odd":"Even");
	return 0;
}