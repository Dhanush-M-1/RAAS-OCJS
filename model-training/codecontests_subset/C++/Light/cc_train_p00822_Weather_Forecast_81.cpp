#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <sstream>
#include <cstring>
#include <cstdio>
#include <cstdlib>
#include <cmath>
#include <queue>
#include <stack>
#include <map>
#include <set>
#include <numeric>
#include <cctype>
#include <tuple>
#include <array>
#include <cassert>

// BEGIN CUT HERE
#ifdef _MSC_VER
#include <agents.h>
#endif
// END CUT HERE 

#define FOR(i, a, b) for(int i = (a); i < (int)(b); ++i)
#define rep(i, n) FOR(i, 0, n)
#define ALL(v) v.begin(), v.end()
#define REV(v) v.rbegin(), v.rend()
#define UNIQUE(v) v.erase(unique(ALL(v)), v.end())
#define MEMSET(v, s) memset(v, s, sizeof(v))
#define MP make_pair
#define MT make_tuple

using namespace std;

typedef long long ll;
typedef pair<int, int> P;
typedef unsigned long long ull;

int vis[400][7][7][7][7][3][3];
int ng[400][3][3];

int dx[] = { 0, 1, 0, -1 };
int dy[] = { -1, 0, 1, 0 };

int dx2[] = { 0, 1, 0, 1 };
int dy2[] = { 0, 0, 1, 1 };

int n;
void dfs(int d, int lt, int rt, int lb, int rb, int x, int y){
	if (lt > 6 || rt > 6 || lb > 6 || rb > 6) return;
	if (d == n){
		//cout << lt << ' ' << rt << ' ' << lb << ' ' << rb << endl;
		throw 1;
		return;
	}
	if (ng[d][x][y] || vis[d][lt][rt][lb][rb][x][y]) return;
	vis[d][lt][rt][lb][rb][x][y] = 1;
	++lt, ++rt, ++lb, ++rb;
	int pos = y * 3 + x;
	if (pos == 0) lt = 0;
	if (pos == 2) rt = 0;
	if (pos == 6) lb = 0;
	if (pos == 8) rb = 0;

	FOR(k, 1, 3) rep(dir, 4){
		int nx = x + dx[dir] * k;
		int ny = y + dy[dir] * k;
		if (nx < 0 || nx >= 3 || ny < 0 || ny >= 3) continue;
		dfs(d + 1, lt, rt, lb, rb, nx, ny);
	}
	dfs(d + 1, lt, rt, lb, rb, x, y);
}

int main(){
	while (cin >> n, n){
		MEMSET(vis, 0);
		MEMSET(ng, 0);

		rep(d, n) rep(y, 4) rep(x, 4){
			int a;
			cin >> a;
			if (!a) continue;
			int xx = x - 1, yy = y - 1;
			rep(dir, 4){
				int nx = xx + dx2[dir], ny = yy + dy2[dir];
				if (nx < 0 || nx >= 3 || ny < 0 || ny >= 3) continue;
				ng[d][nx][ny] = 1;
			}
		}

		try{
			 dfs(0, 0, 0, 0, 0, 1, 1);
			 cout << 0 << endl;
		}
		catch(int x){
			cout << 1 << endl;
		}
	}


	return 0;
}