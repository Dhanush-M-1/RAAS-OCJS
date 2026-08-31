#include <bits/stdc++.h>
using namespace std;
using ll = long long;

void rec(int n, int k, string s = "") {
	if (n == 0) {
		cout << s << endl;
		return;
	}
	for (int i = 0; i < k; ++i) {
		rec(n - 1, k, s + (char)('a' + i));
	}
	rec(n - 1, k + 1, s + (char)('a' + k));
}

int main() {
	int n;
	cin >> n;
	rec(n, 0);
}