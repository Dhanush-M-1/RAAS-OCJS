#include<stdio.h>
#include<vector>
#include<algorithm>
using namespace std;
#define SIZE 210000
class unionfind
{
public:
	int par[SIZE];
	int ran[SIZE];
	int ren[SIZE];
	void init()
	{
		for (int i = 0; i<SIZE; i++)
		{
			par[i] = i;
			ran[i] = 0;
			ren[i] = 1;
		}
	}
	int find(int a)
	{
		if (a == par[a])return a;
		else return par[a] = find(par[a]);
	}
	void unite(int a, int b)
	{
		a = find(a);
		b = find(b);
		if (a == b)return;
		if (ran[a]>ran[b])
		{
			par[b] = a;
			ren[a] += ren[b];
		}
		else
		{
			par[a] = b;
			ren[b] += ren[a];
		}
		if (ran[a] == ran[b])ran[b]++;
	}
};
unionfind uf;
typedef long long ll;
typedef pair<ll, ll>pii;
typedef pair<ll, pii>pi3;
ll dat[202020];
vector<pi3>pat;
#define INF 1000000000000000000LL
void dfs(int beg, int end, ll dis)
{
	if (beg == end)return;
	int med = (beg + end) / 2;
	ll mini1 = INF, mini2 = INF;
	int r1 = -1, r2 = -1;
	for (int i = beg; i <= med; i++)if (mini1 > dis*(med - i) + dat[i])mini1 = dis*(med - i) + dat[i], r1 = i;
	for (int i = med + 1; i <= end; i++)if (mini2 > dis*(i - med) + dat[i])mini2 = dis*(i - med) + dat[i], r2 = i;
	for (int i = beg; i <= med; i++)pat.push_back(make_pair(dis*(r2 - i) + dat[i] + dat[r2], make_pair(i, r2)));
	for (int i = med + 1; i <= end; i++)pat.push_back(make_pair(dis*(i - r1) + dat[i] + dat[r1], make_pair(i, r1)));
	dfs(beg, med, dis), dfs(med + 1, end, dis);
}
int main()
{
	int num;
	ll dis;
	scanf("%d%lld", &num, &dis);
	for (int i = 0; i < num; i++)scanf("%lld", &dat[i]);
	dfs(0, num - 1, dis);
	sort(pat.begin(), pat.end());
	uf.init();
	ll s = 0;
	for (int i = 0; i < pat.size(); i++)
	{
		int u = pat[i].second.first, v = pat[i].second.second;
		if (uf.find(u) != uf.find(v))
		{
			uf.unite(u, v);
			s += pat[i].first;
		}
	}
	printf("%lld\n", s);
}