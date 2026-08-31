#include <bits/stdc++.h>  

using namespace std;

#define FOR(i, j, k) for(int i = j; i < k; ++i)
#define rep(i, j) FOR(i, 0, j)
#define repr(i, j) for(int i = j; i >= 0; --i)
#define INF (1 << 30)
#define MOD 1e9 + 7

typedef long long ll;
typedef unsigned long long ull;
typedef pair<char, int> P;

char mark[5] = "SHCD";
map<P, bool> m;

int main() {
	int N;
	scanf("%d", &N);
	rep(i, N) {
		char a;
		int b;
		cin >> a >> b;
		m[P(a, b)] = true;
	}
	rep(i, 4) FOR(j, 1, 14) {
		if(!m[P(mark[i], j)]) printf("%c %d\n", mark[i], j);
	} 
	return 0;
}