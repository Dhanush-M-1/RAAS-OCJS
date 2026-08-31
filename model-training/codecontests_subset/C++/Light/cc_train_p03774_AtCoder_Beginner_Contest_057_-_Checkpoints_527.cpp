#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
typedef pair<int, int> pii;



int main()
{
	int n,m,a[55],b[55],c,d;
	vector<pair<int,int>>v[55];
	cin>>n>>m;
	for(int i=0;i<n;i++)
	{
		cin>>a[i]>>b[i];
	}
	for(int i=0;i<m;i++)
	{
		cin>>c>>d;
		for(int j=0;j<n;j++)
		{
			v[j].push_back(make_pair(abs(a[j]-c)+abs(b[j]-d),i+1));
		}
	}
	for(int i=0;i<n;i++)
	{
		sort(v[i].begin(),v[i].end());
		cout<<v[i][0].second<<endl;
	}
	return 0;
}