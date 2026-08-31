#include<stdio.h>
#include<vector>
#include<algorithm>
using namespace std;
typedef long long ll;
typedef pair<ll, ll>pii;
int main()
{
	ll gen;
	int num;
	scanf("%lld%d", &gen, &num);
	vector<pii>qs;
	for (int i = 0; i < num; i++)
	{
		ll z;
		scanf("%lld", &z);
		qs.push_back(make_pair(z, -1));
	}
	int query;
	scanf("%d", &query);
	for (int i = 0; i < query; i++)
	{
		int za, zb;
		scanf("%d%d", &za, &zb);
		qs.push_back(make_pair(za, zb));
	}
	sort(qs.begin(), qs.end());
	ll mina = 0;
	ll lb = 0, ub = gen;
	ll bef = 0;
	int d = 0;
	for (int i = 0; i < qs.size(); i++)
	{
		if (qs[i].second == -1)
		{
			ll t = qs[i].first - bef;
			if (d == 0)
			{
				if (t < lb)lb -= t, ub -= t;
				else if (t < ub)mina += t - lb, lb = 0, ub -= t;
				else lb = ub = 0;
			}
			else
			{
				if (t < gen - ub)lb += t, ub += t;
				else if (t < gen - lb)lb += t, ub = gen;
				else lb = ub = gen;
			}
			d ^= 1;
			bef = qs[i].first;
		}
		else
		{
			ll t = qs[i].first - bef;
			ll z;
			if (qs[i].second < mina)z = lb;
			else if (qs[i].second <= mina + ub - lb)z = lb + (qs[i].second - mina);
			else z = ub;
			if (d == 0)z = max(z - t, 0LL);
			else z = min(z + t, gen);
			printf("%lld\n", z);
		}
	}
}