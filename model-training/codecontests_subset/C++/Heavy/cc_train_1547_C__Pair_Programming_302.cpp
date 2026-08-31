#include<bits/stdc++.h>
#define ll long long int
#define pb push_back
#define fastio ios_base::sync_with_stdio(0);cin.tie(0);cout.tie(0);
using namespace std;
ll nad()
{
	ll n,m,k;
	cin>>k>>n>>m;
	ll a[n],b[m];
	vector<ll>ans;
	for(ll i=0;i<n;i++)
	{
		cin>>a[i];
	}
	for(ll i=0;i<m;i++)
	{
		cin>>b[i];
	}
	ll cur1=0,cur2=0,cnt=k;
	for(int i=0;i<n+m+5;i++)
	{
	//	cout<<"i= "<<i<<endl;
		if(cur1<n && a[cur1]==0)
		{
			ans.pb(a[cur1]);
			cnt++;
			cur1++;
		}
		else if(cur2<m && b[cur2]==0)
		{
			ans.pb(b[cur2]);
			cnt++;
			cur2++;
		}
		else if(cur1<n && cur2<m && a[cur1]!=0 && b[cur2]!=0)
		{
			if(a[cur1]<b[cur2])
			{
				if(a[cur1]<=cnt)
				{
					ans.pb(a[cur1]);
					cur1++;
				}
				else
				{
					cout<<"-1"<<endl;
					return 0;
				}
			}
			else
			{
				if(b[cur2]<=cnt)
				{
					ans.pb(b[cur2]);
					cur2++;
				}
				else
				{
					cout<<"-1"<<endl;
					return 0;
				}
			}
		}
		else if(cur2>=m && cur1<n)
		{
			if(a[cur1]<=cnt)
			{
				ans.pb(a[cur1]);
				cur1++;
			}
			else
			{
				cout<<"-1"<<endl;
				return 0;
			}
		}
		else if(cur2<m && cur1>=n)
		{
			if(b[cur2]<=cnt)
			{
				ans.pb(b[cur2]);
				cur2++;
			}
			else
			{
				cout<<"-1"<<endl;
				return 0;
			}
		}
	}
//	cout<<"ans.size()= "<<ans.size()<<endl;
//	if(ans.size()!=(n+m))
//	{
//		cout<<"No!!"<<endl;
//		return 0;
//	}
	for(ll i=0;i<ans.size();i++)
	{
		cout<<ans[i]<<" ";
	}
	cout<<endl;
	return 0;
}
int main()
{
	fastio;
	ll t;
	cin>>t;
	while(t--)
	{
		nad();
	}
	return 0;
}