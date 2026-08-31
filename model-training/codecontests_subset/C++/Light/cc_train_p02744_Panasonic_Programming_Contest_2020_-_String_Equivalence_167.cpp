#include <bits/stdc++.h>
using namespace std;

int n;

void dfs(string s, char c) {
	if (s.size() == n) {
		cout << s << '\n';
	} else {
		for (char i = 'a'; i <= c; i++)
			dfs(s + i, (i == c) ? c + 1 : c);
	}
}

int main() {
	ios::sync_with_stdio(0), cin.tie(0);
	cin >> n;
	dfs("", 'a');
}