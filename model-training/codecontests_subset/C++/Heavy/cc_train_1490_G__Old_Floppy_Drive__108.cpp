#include <bits/stdc++.h>
#define IO ios_base::sync_with_stdio(false);\
		   cin.tie(0);\
		   cout.tie(0)
using namespace std;
typedef long long ll;
const int N = 2e5 + 10;
int t;
int n, m;
ll a[N], b[N];
ll c[N];
int main()
{
    IO;
    cin >> t;
    while(t --)
    {
    	cin >> n >> m;
    	for(int i = 1; i <= n; i ++)
    	{
    		cin >> a[i];
    		a[i] += a[i - 1];
    		c[i] = max(c[i - 1], a[i]);
		}
		for(int i = 1; i <= m; i ++)
		{
			cin >> b[i];
			if(c[n] >= b[i])
				cout<<lower_bound(c + 1, c + n + 1, b[i]) - c - 1<<" ";
			else
			{
				if(a[n] <= 0)
					cout<<"-1"<<" ";
				else
				{
					ll sum = (b[i] - c[n] + a[n] - 1) / a[n];
					b[i] -= sum * a[n];
					sum *= n;
					sum += lower_bound(c + 1, c + n + 1, b[i]) - c - 1;
					cout<<sum<<" ";
				}
			}
		}
		cout<<'\n';
	}
    return 0;
}