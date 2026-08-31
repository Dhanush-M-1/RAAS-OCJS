#include<bits/stdc++.h>
using namespace std ;
#define endl "\n"
 
 
void solve()
{
	int k,n,m;
	cin>>k>>n>>m;
 
	int a[n],b[m];
	for(int i=0;i<n;i++)cin>>a[i];
	for(int i=0;i<m;i++)cin>>b[i];

	bool f=true;
	int i=0,j=0;
	vector<int> v;
	while(i<n and j<m)
	{
		if(a[i]==0)
		{
			v.push_back(a[i]);
			k++;
			i++;
		}
		else if(b[j]==0)
		{
			v.push_back(b[j]);
			k++;
			j++;
		}
		else if(a[i]<=k)
		{
			v.push_back(a[i]);
			i++;
		}
		else if(b[j]<=k)
		{
			v.push_back(b[j]);
			j++;
		}
		else
		{
			f=false ;
			break;
		}
	}
	while(i<n and f==true)
	{
		if(a[i]>k)
		{
			f=false;
			break;
		}
		else if(a[i]==0)
		{
		v.push_back(a[i]);
		k++;
		i++;
		}
		else if(a[i]<=k)
		{
			v.push_back(a[i]);
			i++;
		}
	}
	while(j<m and f==true)
	{
		if(b[j]>k)
		{
			f=false;
			break;
		}
		else if(b[j]==0)
		{
		v.push_back(b[j]);
		k++;
		j++;
		}
		else if(b[j]<=k)
		{
			v.push_back(b[j]);
			j++;
		}
		
	}

 
	if(f)
	{
		for(auto x: v)
		cout<<x <<" ";
	}
	else 
	cout<<-1;
 
	cout<<endl;
}
int32_t main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
 
	int t;
	cin>>t;
	while(t--)
	{
		solve();
	}
 
	return 0;
}