#include <iostream>
#include <algorithm>

using namespace std;

int n;
string s;

void rec(int i, char mx) {
	if (i == n - 1) {
		cout << s << endl;
		return;
	}
	for (char c = 'a'; c <= mx + 1; ++c) {
		s[i + 1] = c;
		rec(i + 1, max(mx, c));
	}
}

int main() {
	cin >> n;
	s.assign(n, ' ');
	s[0] = 'a';
	rec(0, 'a');
	return 0;
}