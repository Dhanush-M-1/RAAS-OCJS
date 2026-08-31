#include <bits/stdc++.h>
using namespace std;
int A, B;
int main() {
	cin >> A >> B;
	cout << ((A * B) % 2 <= 0 ? "Even" : "Odd") << endl;
}