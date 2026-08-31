#include <bits/stdc++.h>
#include <string>
using namespace std;

#define IOS ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
#define ll long long
#define pb push_back
#define fi first
#define se second
const ll mod = 1e9+7;
#define loop(i,a,b) for (ll i = a; i < b; ++i)
#define revloop(i,a,b) for (ll i = a; i > b ; i--)
const ll MAX=100005;

int32_t main()
{
	IOS
	
	ll t;
	cin>>t;
	while(t--)
	{
		int k , n, m;
		cin>>k>>n>>m;
		vector<int> a(n);
		vector<int> b(m);
		loop(i,0,n) cin>>a[i];
		loop(i,0,m) cin>>b[i];
		int x=0;
		int y=0;
		bool f =true;
		vector<int> res;
		loop(z,0,n+m)
		{
			if (x<n and a[x]==0)
			{
				k++;
				res.pb(a[x]);
				x++;
			}
			else if (y<m and b[y]==0)
			{
				k++;
				res.pb(b[y]);
				y++;
			}
			else if (y==m or (x<n and a[x]<b[y]))
			{
				if(a[x]<=k)
				{
					res.pb(a[x]);
					x++;
				}
				else
				{
					f=false;
					break;
				}
			}
			else
			{
				if(b[y]<=k)
				{
					res.pb(b[y]);
					y++;
				}
				else
				{
					f=false;
					break;
				}
			}
			

		}
		if(f)
		{
			for(int i : res)
			{
				cout<<i<<' ';
			}
			cout<<endl;
		}
		else
		{
			cout<<-1<<endl;
		}
	}
	return 0;
}