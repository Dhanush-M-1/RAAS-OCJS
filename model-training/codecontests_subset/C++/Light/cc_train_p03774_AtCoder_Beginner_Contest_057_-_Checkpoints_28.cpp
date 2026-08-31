#include<bits/stdc++.h>
using namespace std;
int a[55],b[55],c[55],d[55];
int main()
{
	int n,m;
	cin>>n>>m;
	for(int i=1;i<=n;i++) cin>>a[i]>>b[i];
	for(int i=1;i<=m;i++) cin>>c[i]>>d[i];
	for(int i=1;i<=n;i++)
	{
		int dmin=1234567890,minp;
		for(int j=1;j<=m;j++)
		if(dmin>abs(a[i]-c[j])+abs(b[i]-d[j]))
		dmin=abs(a[i]-c[j])+abs(b[i]-d[j]),minp=j;
		cout<<minp<<endl;
	}
	return 0;
}