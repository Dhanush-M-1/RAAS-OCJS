#include<iostream>

using namespace std;

int main(void)
{
	int n,m;
	cin >> n >> m;
	long long a[55],b[55],c[55],d[55];
	for(int i=1;i<=n;i++)
		cin >> a[i-1] >> b[i-1];
	for(int i=1;i<=m;i++)
		cin >> c[i-1] >> d[i-1];
	
	for(int i=1;i<=n;i++)
	{
		int ans=0;
		long long ansdis=5000000009;
		for(int j=1;j<=m;j++)
		{
			long long dis=abs(a[i-1]-c[j-1])+abs(b[i-1]-d[j-1]);
			if(dis<ansdis)
			{
				ansdis=dis;
				ans=j;
			}
		}
		cout << ans << endl;
	}
}