#include<bits/stdc++.h>
using namespace std;

int main()
{
	int n,m;
	cin>>n>>m;
	int ans,a[n],b[n],c[m],d[m];
	for(int i=0; i<n; i++)
	{
		cin>>a[i];
		cin>>b[i];
	}
	for(int j=0; j<m; j++)
	{
		cin>>c[j];
		cin>>d[j];
	}
	for(int p=0; p<n; p++)
	{
		int min=INT_MAX;
		for(int q=0; q<m; q++)
		{
			int dist=abs(a[p]-c[q])+abs(b[p]-d[q]);
			if(dist<min)
			{
				min=dist;
				ans=q;
			}
		}
		cout<<ans+1<<endl;
	}
}
