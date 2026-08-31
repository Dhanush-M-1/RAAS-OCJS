#include <bits/stdc++.h>
using namespace std;
#define rep(i,n) for (int i = 0; i < (n); ++i)

int N;
void dfs(string s, char m) {
	if(s.size() == N) {
		cout << s << endl;
		return;
	}
	rep(i,m-'a'+1) {
		char tm = m;
		if((char)('a'+i) == m)
			++tm;
		dfs(s+(char)('a'+i), tm);
	}
}

int main() {
	cin >> N;
	dfs("", 'a');
}