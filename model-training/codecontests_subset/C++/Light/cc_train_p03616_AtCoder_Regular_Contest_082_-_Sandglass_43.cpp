#include <bits/stdc++.h>

const int N = 100005;

int all, k, q, r[N], t[N], a[N];
int up, down, c;
int main() {
	std::ios::sync_with_stdio(0), std::cin.tie(0);
	std::cin >> all >> k;
	for (int i = 1; i <= k; ++i)
		std::cin >> r[i];
	r[0] = 0, r[k + 1] = 1e9 + 1;
	std::cin >> q; int p = 0;
	for (int i = 0; i < q; ++i)
		std::cin >> t[i] >> a[i];
	up = all; int typ = 0;
	for (int i = 0; i <= k && p < q; ++i) {
		while (p < q && t[p] >= r[i] && t[p] < r[i + 1]) {
			int x = std::min(std::max(a[p] + c, down), up), d = t[p++] - r[i];
			if (typ) x = std::min(x + d, all); else x = std::max(x - d, 0);
			std::cout << x << '\n';
		}
		int d = r[i + 1] - r[i];
		if (typ) down = std::min(down + d, all), up = std::min(up + d, all), c += d;
		else down = std::max(down - d, 0), up = std::max(up - d, 0), c -= d;
		typ ^= 1;
	}
	return 0;
}