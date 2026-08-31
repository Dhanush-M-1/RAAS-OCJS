#include <iostream>
using namespace std;

int a, b;
int main() {
	cin >> a >> b;
	cout << (a<10 && b<10 ? a*b : -1);
	return 0;
}
