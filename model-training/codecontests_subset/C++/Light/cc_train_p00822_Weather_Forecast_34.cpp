#include <iostream>
#include <vector>
#include <cstring>
#include <string>
#include <algorithm>
#include <iomanip>
#include <cmath>
#include <cassert>
#include <set>
#include <tuple>
#include <unordered_set>
using namespace std;
#define int long long
set<tuple<int, int, int> > done;
int D;
int ds[365];

int dfs(int cl, int d, int cnt) {
	if(d < D && (cl & ds[d])) return 0;
	auto v = make_tuple(cl, d, cnt);
	if(done.count(v)) return 0;
	done.insert(v);
	for(int i = 0; i < 16; i++) {
		int c = (cnt >> (i * 3)) & 7;
		cnt ^= c << (i * 3);
		if(cl & (1LL << i)) c = 0;
		else c++;
		if(c == 7) return 0;
		cnt ^= c << (i * 3);
	}
	if(d == D) return 1;

	for(int i = 0; i < 2; i++) {
		if(dfs(cl, d + 1, cnt)) return 1;
		if(!((4369 << i) & cl) && dfs(cl >> (i + 1), d + 1, cnt)) return 1;
		if(!((34952 >> i) & cl) && dfs(cl << (i + 1), d + 1, cnt)) return 1;
		if(!((15 << (i * 4)) & cl) && dfs(cl >> ((i + 1) * 4), d + 1, cnt)) return 1;
		if(!((61440 >> (i * 4)) & cl) && dfs(cl << ((i + 1) * 4), d + 1, cnt)) return 1;
	}
	return 0;
}

void solve() {
	for(int i = 0; i < D; i++) {
		ds[i] = 0;
		for(int j = 0; j < 16; j++) {
			int a;
			cin >> a;
			ds[i] |= a << j;
		}
	}
	done.clear();

	cout << dfs(1632, 0, 0) << endl;
}

signed main() {
	cin.tie(0);
	ios::sync_with_stdio(false);

	while(cin >> D, D) {
		solve();
	}
}