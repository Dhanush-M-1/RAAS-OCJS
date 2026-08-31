#include<bits/stdc++.h>
using namespace std;
 
#define ll		long long
#define ppb     pop_back
#define pb 		push_back
#define mk      make_pair
#define ff      first
#define ss      second
#define endl	"\n"
#define fast	std::ios_base::sync_with_stdio(false); cin.tie(0); cout.tie(0);	
#define MOD     1000000007


void solve()
{		
	int k,n,m;
	cin >> k >> n >> m;
	int a[n], b[m];
	int cnt = 0;
	for(int i = 0; i < n; i++)
	{
		cin >> a[i];
	}
	for(int j = 0; j < m; j++)
	{
		cin >> b[j];
	}
	int i = 0, j = 0;
	vector<int>ans;
	int flag = 0;
	while(i < n || j < m)
	{
		if(i != n && a[i] == 0)
		{
			ans.pb(a[i]);
			k++;
			i++;
			continue;
		}
		if(j != m && b[j] == 0)
		{
			ans.pb(b[j]);
			k++;
			j++;
			continue;
		}
		if(i != n && a[i] <= k)
		{
			ans.pb(a[i]);
			i++;
			continue;
		}
		if(j != m && b[j] <= k)
		{
			ans.pb(b[j]);
			j++;
			continue;
		}
		flag = 1;
		break;
	}
	if(flag == 1)
		cout << "-1" << endl;
	else
	{
		for(auto it:ans)
			cout << it << " ";
		cout << endl;
	}
	
	
}

signed main()
{
	fast;
	int t=1;
	cin >> t;
	while(t--)
	{
		solve();
	}
	
}