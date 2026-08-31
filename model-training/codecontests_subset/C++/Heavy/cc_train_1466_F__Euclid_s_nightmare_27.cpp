#include <iostream>
#include <map>
#include <algorithm>
#include <queue>
#include <set>
#include <vector>
#include <iomanip>
#include <bitset>
using namespace std;
#define pi pair<int ,int>
int mod = 1e9+7 , n , m , ok[1000000] , lab[1000000];
vector <int> ruler[1000001] , res;
void unite(int u , int v)
{
	if (lab[u] > lab[v])
	{
		swap(u , v);
	}
	lab[u] += lab[v];
	lab[v] = u;
}
int get(int u)
{
	while (lab[u] > 0) u = lab[u];
	return u;
}
int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	int t;
	cin >> n >> m;
	for (int i = 1 ; i <= n ; i++)
	{
		int k , u ,v;
		cin >> k;
		for (int e = 1 ; e <= k ; e++)
		{
			cin >> v;
			ruler[i].push_back(v);
		}
	}
	for (int i = 1 ; i <= m ; i++)
	{
		lab[i] = -1;
	}
	int pre = 0;
	/*for (int i = 1 ; i <= n ; i++)
	{
		if (ruler[i].size() == 1)
		{
			if (pre != 0)
			{
				int u = ruler[i][0];
				if (u != get(pre))
				{
					res.push_back(i);
					unite(u , get(pre));
				}
			}
			else
			{
				res.push_back(i);
			}
			pre = ruler[i][0];
		}
	}*/
	for (int i = 1 ; i <= n ; i++)
	{
		if (ruler[i].size() == 1)
		{
			if (pre != 0)
			{
				int u = ruler[i][0];
				if (get(u) != get(pre))
				{
					res.push_back(i);
					unite(get(u) , get(pre));
				}
			}
			else
			{
				res.push_back(i);
			}
			pre = ruler[i][0];
		}
		else
		{
			int u = ruler[i][0] , v = ruler[i][1];
			int dadu = get(u) , dadv = get(v);
			if (dadu != dadv && ok[u] + ok[v] != 2)
			{
				res.push_back(i);
				unite(dadu , dadv);
			}
		}
	}
	int got = 1;
	for (int i = 1 ; i <= res.size() ; i++)
	{
		got = 1ll * got * 2  % mod;
	}
	sort(res.begin() , res.end());
	cout <<got<<" "<<res.size()<<'\n';
	for (int i = 0 ; i < res.size() ; i++)
	{
		cout <<res[i]<<'\n';
	}
}

