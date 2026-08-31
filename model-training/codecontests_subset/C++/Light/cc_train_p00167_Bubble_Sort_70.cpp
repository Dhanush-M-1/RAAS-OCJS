#include <bits/stdc++.h>
#define rep(i,n) for(int i=0;i<n;i++)
//#define int long long
using namespace std;

int n;
int a[100];

signed main()
{
	while (true)
	{
		cin >> n;
		if (n == 0) break;

		rep(i,n) cin >> a[i];
		int ans = 0;
		for (int i=n-1; 1<=i; i--)
		{
			for (int j=0; j<=i-1; j++)
			{
				if (a[j] > a[j+1])
				{
					swap(a[j], a[j+1]);
					ans++;
				}
			}
		}

		cout << ans << endl;
	}
}