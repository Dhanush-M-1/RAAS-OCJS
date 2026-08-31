#include <iostream>
#include <string>
#include <array>
#include <vector>
#include <queue>
#include <stack>
#include <list>
#include <set>
#include <map>
#include <algorithm>
#include <cmath>
#include <iomanip>

#define FOR(i, a, b) for(decltype(b) i = (a); i < (b); ++i)
#define REP(i, n) FOR(i, 0, n)

typedef long long ll;
typedef unsigned long long ull;
typedef unsigned int uint;

using namespace std;

#ifdef INPUT
#include <sstream>
stringstream input(R"(
3 1
1 100 1
)");
#define cin input
#endif

int main()
{
	int n, d;
	cin >> n >> d;

	vector<int> a(n);

	for (auto& i : a)
		cin >> i;
	
	vector<ll> ld(n), rd(n);
	vector<int> lp(n), rp(n);

	multimap<ll, int> q;

	REP (i, n)
	{
		ld[i] = a[i] - (ll)i * d;
		lp[i] = i;
		rd[n - i - 1] = a[n - i - 1] - (ll)i * d;
		rp[n - i - 1] = n - i - 1;
		if (i)
		{
			if (ld[i] > ld[i - 1])
			{
				ld[i] = ld[i - 1];
				lp[i] = lp[i - 1];
			}
			if (rd[n - i - 1] > rd[n - i])
			{
				rd[n - i - 1] = rd[n - i];
				rp[n - i - 1] = rp[n - i];
			}
		}
	}

	ll r = (ll)d * (n - 1);

	REP (i, n)
	{
		ll ldd = ld[i] - (a[i] - (ll)i * d);
		ll rdd = rd[i] - (a[i] - (ll)(n - i - 1) * d);

		if (i && i != n - 1)
		q.insert(make_pair(min(ldd, rdd), i));

		r += a[i] * 2;
	}

	r -= a[0];
	r -= a[n - 1];

	for (auto p : q)
	{
		r += p.first;
	}

	cout << r << endl;

	return 0;
}
