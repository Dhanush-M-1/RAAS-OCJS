#include <bits/stdc++.h>

const int MAXN = 100010;
int qa[MAXN], ansl[MAXN];
std::map<int, std::vector<int> > qry;
int X, Q;
int main() {
	std::ios_base::sync_with_stdio(false), std::cin.tie(0);
	std::cin >> X >> Q;
	for (int i = 1, t; i <= Q; ++i)
		std::cin >> t, qry[t].push_back(-1);
	std::cin >> Q;
	for (int i = 1, t; i <= Q; ++i)
		std::cin >> t >> qa[i], qry[t].push_back(i);
	int lx = 0, ly = 0, rx = X, ry = X, lst = 0, typ = 0;
	for (auto t : qry) {
		int d = t.first - lst; lst = t.first;
		ly -= d, ry -= d;
		if (ly < 0) lx -= ly, ly = 0;
		if (ry < 0) rx += ry, ry = 0;
		if (lx >= rx) lx = rx = 0;
		for (auto i : t.second) {
			if (i == -1) ly = X - ly, ry = X - ry, typ ^= 1;
			else {
				if (qa[i] <= lx) ansl[i] = ly;
				else if (qa[i] >= rx) ansl[i] = ry;
				else ansl[i] = ly + (ry - ly) / (rx - lx) * (qa[i] - lx);
				if (typ) ansl[i] = X - ansl[i];
			}
		}
	}
	for (int i = 1; i <= Q; ++i) std::cout << ansl[i] << '\n';
	return 0;
}
