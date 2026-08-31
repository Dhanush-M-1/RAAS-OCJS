#include <iostream>
using namespace std;
int N, A;
int main() {
	cin >> N >> A;
	cout << (N*A%2 == 0 ? "Even" : "Odd") << endl;
	return 0;
}
