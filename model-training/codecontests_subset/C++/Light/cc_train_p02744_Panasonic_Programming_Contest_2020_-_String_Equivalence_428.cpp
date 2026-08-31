#include <bits/stdc++.h>
using namespace std;
int N;
vector<string> a;
void f(string s, int p) {
	if (s.length() == N) {
		a.push_back(s);
		return;
	}
	for (int i = 0; i <= p; ++ i) {
		f(s + (char)('a'+i), max(p, i+1));
	}
}
int main() {
	cin >> N;
	f("", 0);
	for (auto x : a) cout << x << endl;
}
