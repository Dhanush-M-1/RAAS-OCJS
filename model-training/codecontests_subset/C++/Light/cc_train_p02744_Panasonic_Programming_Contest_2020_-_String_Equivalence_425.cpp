#include <bits/stdc++.h>
using namespace std;

int n;
string s;

void mrgmkn(char mc) {
	if(s.size() == n) {
		cout << s << "\n";
		return;
	}
	for(char c = 'a'; c <= mc; ++c) {
		s += c;
		mrgmkn((c == mc ? mc + 1 : mc));
		s.pop_back();
	}
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cin >> n;
	mrgmkn('a');
	return 0;
}
