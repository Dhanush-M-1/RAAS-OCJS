#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
void solve()
{
	int k,n,m;
	cin>>k>>n>>m;
	int a[n],b[m];
	vector<int> v;
	for (int i = 0; i < n; ++i)
	{
		cin>>a[i];
	}
	for (int i = 0; i < m; ++i)
	{
		cin>>b[i];
	}
	int i=0,j=0;
	while( i<n && j<m)
	{
		if(a[i]==0)
		{

			v.push_back(a[i]);
			i++;
			k++;
		}
		else if(a[i]<=k)
		{

			v.push_back(a[i]);
			i++;
		}
		else if(b[j]==0)
		{

			v.push_back(b[j]);
			j++;
			k++;
		}
		else if(b[j]<=k)
		{
			v.push_back(b[j]);
			j++;
		}
		else
		{
			cout<<-1<<endl;
			return;
		}
	}
	while(i<n)
	{
		if(a[i]==0)
		{

			v.push_back(a[i]);
			i++;
			k++;
		}
		else if(a[i]<=k)
		{

			v.push_back(a[i]);
			i++;
		}
		else
		{
			cout<<-1<<endl;
			return;
		}
	}
	while(j<m)
	{
		if(b[j]==0)
		{
			v.push_back(b[j]);
			j++;
			k++;
		}
		else if(b[j]<=k)
		{
			v.push_back(b[j]);
			j++;
		}
		else
		{
			cout<<-1<<endl;
			return;
		}
	}
	for (std::vector<int>::iterator i = v.begin(); i != v.end(); ++i)
	{
		cout<<*i<<" ";
	}
	cout<<endl;
}
/*2 0 0 5 
0 2 0 6 5 
-1
0 6 0 7 0 8 0 9
-1
*/
int main()
{
	int t;
	cin>>t;
	while(t--)
	{
		solve();
	}
}