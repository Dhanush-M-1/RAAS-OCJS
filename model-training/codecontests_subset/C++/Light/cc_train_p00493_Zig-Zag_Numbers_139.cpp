#include <iostream>
#include <cstdio>
#include <vector>
#include <cmath>
#include <cstring>
#include <numeric>
#include <algorithm>
#include <functional>
#include <array>
#include <map>
#include <queue>
#include <limits.h>
#include <set>
#include <stack>
#include <random>
#define rep(i,s,n) for(int i = (s); (n) > i; i++)
#define REP(i,n) rep(i,0,n)
#define RANGE(x,a,b) ((a) <= (x) && (x) <= (b))
#define POWT(x) ((x)*(x))
#define ALL(x) (x).begin(), (x).end()
#define MODI 10000
using namespace std;
typedef pair<int, int> pii;
typedef long long ll;

template<int MOD>
struct ModInt {
	static const int Mod = MOD;
	unsigned x;
	ModInt() : x(0) {}
	ModInt(signed sig) { int sigt = sig % MOD; if (sigt < 0) sigt += MOD; x = sigt; }
	ModInt(signed long long sig) { int sigt = sig % MOD; if (sigt < 0) sigt += MOD; x = sigt; }
	int get() const { return (int) x; }

	ModInt &operator+=(ModInt that) { if ((x += that.x) >= MOD) x -= MOD; return *this; }
	ModInt &operator-=(ModInt that) { if ((x += MOD - that.x) >= MOD) x -= MOD; return *this; }
	ModInt &operator*=(ModInt that) { x = (unsigned long long)x * that.x % MOD; return *this; }
	ModInt &operator/=(ModInt that) { return *this *= that.inverse(); }

	ModInt operator+(ModInt that) const { return ModInt(*this) += that; }
	ModInt operator-(ModInt that) const { return ModInt(*this) -= that; }
	ModInt operator*(ModInt that) const { return ModInt(*this) *= that; }
	ModInt operator/(ModInt that) const { return ModInt(*this) /= that; }
	//ModInt operator++(int) const { return ModInt(*this) += 1; }
	//ModInt operator--(int) const { return ModInt(*this) -= 1; }

	ModInt inverse() const {
		signed a = x, b = MOD, u = 1, v = 0;
		while (b) {
			signed t = a / b;
			a -= t * b; std::swap(a, b);
			u -= t * v; std::swap(u, v);
		}
		if (u < 0) u += Mod;
		ModInt res; res.x = (unsigned) u;
		return res;
	}
};
signed main() {
	char stra[502], strb[502];
	int a[502] = {}, b[502] = {}, m;

	ModInt<MODI> ans = 0;

	scanf("%s %s %d", stra, strb, &m);
	int alen = strlen(stra), blen = strlen(strb);
	int mmm = 0;
	REP(i, alen) {
		a[i] = stra[i]-'0';
		mmm = (mmm * 10 + a[i]) % m;
	}
	bool zii = 1;
	for(int i = 1; alen > i; i++){
		if ((i % 2) && a[i] > a[i - 1]) {
			zii = 0;
			break;
		}
		if (!(i % 2) && a[i] < a[i - 1]) {
			zii = 0;
			break;
		}
	}
	if (zii) {
		for (int i = 1; alen > i; i++) {
			if (!(i % 2) && a[i] > a[i - 1]) {
				zii = 0;
				break;
			}
			if ((i % 2) && a[i] < a[i - 1]) {
				zii = 0;
				break;
			}
		}
	}
	if (zii && (!mmm))
		ans+=1;
	REP(i, blen) {
		b[i] = strb[i] - '0';
	}
	map<pii, ModInt<MODI>> pnum;//NUM,MOD

	//B
	for (int i = 1; b[0] > i; i++) {
		pnum[{i, i%m}] += 1;
	}
	pnum[{b[0], -(b[0] % m) - 1}] += 1;

	for (int i = 1; blen > i; i++) {//?????????
		map<pii, ModInt<MODI>> next;

		for (auto cur : pnum) {
			if (cur.first.second < 0) {
				if (i % 2) {
					for (int j = cur.first.first + 1; b[i] > j; j++) {
						next[{j, (-(cur.first.second + 1) * 10 + j) % m}] += cur.second;
					}
					if (b[i] > cur.first.first) {
						next[{b[i], -(((-(cur.first.second + 1)) * 10 + b[i]) % m) - 1}] += cur.second;
					}
				}
				else {
					for (int j = min(cur.first.first, b[i]) - 1; 0 <= j; j--) {
						next[{j, (-(cur.first.second + 1) * 10 + j) % m}] += cur.second;
					}
					if (b[i] < cur.first.first) {
						next[{b[i], -(((-(cur.first.second + 1)) * 10 + b[i]) % m) - 1}] += cur.second;
					}
				}
			}
			else {
				if (i % 2) {
					for (int j = cur.first.first + 1; 9 >= j; j++) {
						next[{j, (cur.first.second * 10 + j) % m}] += cur.second;
					}
				}
				else {
					for (int j = cur.first.first - 1; 0 <= j; j--) {
						next[{j, (cur.first.second * 10 + j) % m}] += cur.second;
					}
				}
			}
		}
		for (int i = 1; 9 >= i; i++) {
			next[{i, i%m}] += 1;
		}
		pnum.swap(next);
	}

	for (auto cur : pnum) {
		if (cur.first.second == 0 || cur.first.second == -1) {
			ans += cur.second;
		}
	}



	pnum.clear();



	if (blen > 1) {
		for (int i = 1; b[0] > i; i++) {
			pnum[{i, i%m}] += 1;
		}
		pnum[{b[0], -(b[0] % m) - 1}] += 1;

		for (int i = 1; blen > i; i++) {//?????????
			map<pii, ModInt<MODI>> next;

			for (auto cur : pnum) {
				if (cur.first.second < 0) {
					if (!(i % 2)) {
						for (int j = cur.first.first + 1; b[i] > j; j++) {
							next[{j, (-(cur.first.second + 1) * 10 + j) % m}] += cur.second;
						}
						if (b[i] > cur.first.first) {
							next[{b[i], -(((-(cur.first.second + 1)) * 10 + b[i]) % m) - 1}] += cur.second;
						}
					}
					else {
						for (int j = min(cur.first.first, (int) b[i]) - 1; 0 <= j; j--) {
							next[{j, (-(cur.first.second + 1) * 10 + j) % m}] += cur.second;
						}
						if (b[i] < cur.first.first) {
							next[{b[i], -(((-(cur.first.second + 1)) * 10 + b[i]) % m) - 1}] += cur.second;
						}
					}
				}
				else {
					if (!(i % 2)) {
						for (int j = cur.first.first + 1; 9 >= j; j++) {
							next[{j, (cur.first.second * 10 + j) % m}] += cur.second;
						}
					}
					else {
						for (int j = cur.first.first - 1; 0 <= j; j--) {
							next[{j, (cur.first.second * 10 + j) % m}] += cur.second;
						}
					}
				}
			}
			if (i < (blen - 1)) {
				for (int i = 1; 9 >= i; i++) {
					next[{i, i%m}] += 1;
				}
			}
			else {
				printf("");
			}
			pnum.swap(next);
		}

		for (auto cur : pnum) {
			if (cur.first.second == 0 || cur.first.second == -1) {
				ans += cur.second;
			}
		}
		pnum.clear();
	}

	//A
	for (int i = 1; a[0] > i; i++) {
		pnum[{i, i%m}] += 1 ;
	}
	pnum[{a[0], -(a[0] % m) - 1}] += 1;

	for (int i = 1; alen > i; i++) {//?????????
		map<pii, ModInt<MODI>> next;

		for (auto cur : pnum) {
			if (cur.first.second < 0) {
				if (i % 2) {
					for (int j = cur.first.first + 1; a[i] > j; j++) {
						next[{j, (-(cur.first.second + 1) * 10 + j) % m}] += cur.second;
					}
					if (a[i] > cur.first.first) {
						next[{a[i], -(((-(cur.first.second + 1)) * 10 + a[i]) % m) - 1}] += cur.second;
					}
				}
				else {
					for (int j = min(cur.first.first, (int) a[i]) - 1; 0 <= j; j--) {
						next[{j, (-(cur.first.second + 1) * 10 + j) % m}] += cur.second;
					}
					if (a[i] < cur.first.first) {
						next[{a[i], -(((-(cur.first.second + 1)) * 10 + a[i]) % m) - 1}] += cur.second;
					}
				}
			}
			else {
				if (i % 2) {
					for (int j = cur.first.first + 1; 9 >= j; j++) {
						next[{j, (cur.first.second * 10 + j) % m}] += cur.second;
					}
				}
				else {
					for (int j = cur.first.first - 1; 0 <= j; j--) {
						next[{j, (cur.first.second * 10 + j) % m}] += cur.second;
					}
				}
			}
		}
		for (int i = 1; 9 >= i; i++) {
			next[{i, i%m}] += 1;
		}
		pnum.swap(next);
	}

	for (auto cur : pnum) {
		if (cur.first.second == 0 || cur.first.second == -1) {
			ans -= cur.second;
		}
	}






	pnum.clear();


	if (alen > 1) {
		for (int i = 1; a[0] > i; i++) {
			pnum[{i, i%m}] += 1;
		}
		pnum[{a[0], -(a[0] % m) - 1}] += 1;

		for (int i = 1; alen > i; i++) {//?????????
			map<pii, ModInt<MODI>> next;

			for (auto cur : pnum) {
				if (cur.first.second < 0) {
					if (!(i % 2)) {
						for (int j = cur.first.first + 1; a[i] > j; j++) {
							next[{j, (-(cur.first.second + 1) * 10 + j) % m}] += cur.second;
						}
						if (a[i] > cur.first.first) {
							next[{a[i], -(((-(cur.first.second + 1)) * 10 + a[i]) % m) - 1}] += cur.second;
						}
					}
					else {
						for (int j = min(cur.first.first, (int) a[i]) - 1; 0 <= j; j--) {
							next[{j, (-(cur.first.second + 1) * 10 + j) % m}] += cur.second;
						}
						if (a[i] < cur.first.first) {
							next[{a[i], -(((-(cur.first.second + 1)) * 10 + a[i]) % m) - 1}] += cur.second;
						}
					}
				}
				else {
					if (!(i % 2)) {
						for (int j = cur.first.first + 1; 9 >= j; j++) {
							next[{j, (cur.first.second * 10 + j) % m}] += cur.second;
						}
					}
					else {
						for (int j = cur.first.first - 1; 0 <= j; j--) {
							next[{j, (cur.first.second * 10 + j) % m}] += cur.second;
						}
					}
				}
			}
			if (i < (alen - 1)) {
				for (int i = 1; 9 >= i; i++) {
					next[{i, i%m}] += 1;
				}
			}
			pnum.swap(next);
		}


		for (auto cur : pnum) {
			if (cur.first.second == 0 || cur.first.second == -1) {
				ans -= cur.second;
			}
		}
	}

	printf("%d\n", ans);


	return 0;
}