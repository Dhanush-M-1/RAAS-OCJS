#define _USE_MATH_DEFINES
#include <algorithm>
#include <cstdio>
#include <functional>
#include <iostream>
#include <cfloat>
#include <climits>
#include <cstring>
#include <cmath>
#include <map>
#include <queue>
#include <set>
#include <sstream>
#include <stack>
#include <string>
#include <time.h>
#include <vector>
using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> i_i;
typedef pair<ll, int> ll_i;
typedef pair<double, int> d_i;
typedef pair<ll, ll> ll_ll;
typedef pair<double, double> d_d;
struct edge { int u, v; ll w; };

ll MOD = 1000000007;
ll _MOD = 1000000009;
double EPS = 1e-10;

int enc(int x, int y) {
	return x + y * 3;
}

int _enc(int a, int b, int c, int d) {
	return (a << 9) + (b << 6) + (c << 3) + d;
}

int main() {
	for (;;) {
		int N; cin >> N;
		if (N == 0) break;
		vector< vector<bool> > dp(9, vector<bool>(4096));
		dp[4][_enc(1, 1, 1, 1)] = true;
		while (N--) {
			vector< vector<bool> > v(3, vector<bool>(3, true));
			for (int y = 0; y < 4; y++)
			for (int x = 0; x < 4; x++) {
				int f; cin >> f;
				if (!f) continue;
				for (int _y = 0; _y < 3; _y++)
				for (int _x = 0; _x < 3; _x++)
					if (x - _x >= 0 && x - _x < 2 && y - _y >= 0 && y - _y < 2)
						v[_y][_x] = false;
			}
			vector< vector<bool> > _dp(9, vector<bool>(4096));
			for (int y = 0; y < 3; y++)
			for (int x = 0; x < 3; x++) {
				if (!v[y][x]) continue;
				for (int a = 0; a < 7; a++)
				for (int b = 0; b < 7; b++)
				for (int c = 0; c < 7; c++)
				for (int d = 0; d < 7; d++) {
					int i = enc(x, y), j = _enc(a, b, c, d);
					if (!dp[i][j]) continue;
					for (int _y = 0; _y < 3; _y++)
					for (int _x = 0; _x < 3; _x++) {
						if (_x != x && _y != y) continue;
						int _a = (_x == 0 && _y == 0 ? 0 : a + 1);
						int _b = (_x == 2 && _y == 0 ? 0 : b + 1);
						int _c = (_x == 0 && _y == 2 ? 0 : c + 1);
						int _d = (_x == 2 && _y == 2 ? 0 : d + 1);
						int _i = enc(_x, _y), _j = _enc(_a, _b, _c, _d);
						_dp[_i][_j] = true;
					}
				}
			}
			dp = _dp;
			/*
			int ok = 100;
			for (int y = 0; y < 3; y++)
			for (int x = 0; x < 3; x++)
			for (int a = 0; a < 7; a++)
			for (int b = 0; b < 7; b++)
			for (int c = 0; c < 7; c++)
			for (int d = 0; d < 7; d++) {
				int i = enc(x, y), j = _enc(a, b, c, d);
				if (dp[i][j]) ok = min(ok, a);
			}
			cout << ok << endl;
			*/
		}
		bool ok = false;
		for (int y = 0; y < 3; y++)
		for (int x = 0; x < 3; x++)
		for (int a = 0; a < 7; a++)
		for (int b = 0; b < 7; b++)
		for (int c = 0; c < 7; c++)
		for (int d = 0; d < 7; d++) {
			int i = enc(x, y), j = _enc(a, b, c, d);
			if (dp[i][j]) ok = true;
		}
		cout << (ok ? 1 : 0) << endl;
	}
}